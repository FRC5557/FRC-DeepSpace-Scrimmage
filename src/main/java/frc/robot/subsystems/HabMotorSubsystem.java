/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HabMotorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static HabMotorSubsystem instance = null;

  WPI_TalonSRX motor1 = new WPI_TalonSRX(RobotMap.HAB_MOTOR_1);
  WPI_TalonSRX motor2 = new WPI_TalonSRX(RobotMap.HAB_MOTOR_2);

  public static HabMotorSubsystem getInstance() {
    if(instance == null) {
      instance = new HabMotorSubsystem();
    }
    return instance;
  }

  public void moveForward() {
    motor1.set(.5);
    motor2.set(.5);
  }

  public void moveBack() {
    motor1.set(-.5);
    motor2.set(-.5);
  }

  public void stop() {
    motor1.set(0);
    motor2.set(0);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}