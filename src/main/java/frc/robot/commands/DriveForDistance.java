/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveForDistance extends Command {

  private int desiredEncoderVal;
  private int speed;
  private DriveSubsystem drive = DriveSubsystem.getInstance();

  private int currentEncoderVal = 0;

  public DriveForDistance(double encoderValue, double speed) {
    // pass in desired distance or encoder value

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.desiredEncoderVal = encoderValue;
    this.speed = speed;
    requires(DriveSubsystem.getInstance());
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // reset encoder values
    drive.resetEncoders();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // add constant driving code here
    drive.drive(0, speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // grab current encoder value
    // write logic here to calculate if the desired encoder value - current encoder
    // value <= 0
    if(desiredEncoderVal - currentEncoderVal <= 0) {
      return true;
    }
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
