/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends Command {

  private Joystick stick = Robot.m_oi.stick;
  private DriveSubsystem drive = DriveSubsystem.getInstance();

  double[] restingTriggerVals = new double[2];


  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(DriveSubsystem.getInstance());
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    stick.setXChannel(0);
		stick.setTwistChannel(3);
		stick.setThrottleChannel(4);
		stick.setZChannel(2);

    restingTriggerVals = triggerCalibrate();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // add drive command here
    // first thing it should do is read stick values
     double turn = 0;
		double throttle = 0;
		//Controller Drive
		turn = stick.getX() > 0 ? stick.getX()*1 : stick.getX()*1;
		throttle = getTrigerThrottle(stick.getTwist(), stick.getThrottle());
    drive.drive(-1*turn, throttle);
  }

  public double getTrigerThrottle(double leftT, double rightT){
		double fThrottle = 0;
		if(rightT > restingTriggerVals[0]+.1){ //forward input will always take priority over reverse input
			fThrottle = (rightT*(1/1.6)+.30);
		}else if(leftT > restingTriggerVals[1]){
			fThrottle = -(leftT*(1/1.6)+.45); //backward has slightly higher offset because motors are slower backwards
		}
		return fThrottle;
  }



  public double[] triggerCalibrate(){
		double [] callVal = new double[2];
		callVal[0] = stick.getTwist(); //left trigger
		callVal[1] = stick.getThrottle(); //right trigger
		System.out.println("Left Trigger: " + callVal[0]);
		System.out.println("Right Trigger: " + callVal[1]);
		return callVal;
	}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // returns false because it should constantly read values
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    drive.drive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
