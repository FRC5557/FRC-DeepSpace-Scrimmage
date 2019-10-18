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
public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static ElevatorSubsystem instance = null;

  private final WPI_TalonSRX elevatorTalonLeft;
  private final WPI_TalonSRX elevatorTalonRight;

  public static ElevatorSubsystem getInstance() {
    if (instance == null) {
      instance = new ElevatorSubsystem();
    }
    return instance;
  }

  public ElevatorSubsystem() {
    elevatorTalonLeft = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_LEFT);
    elevatorTalonRight = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_RIGHT);

  }

  public void drive(double speed) {
    elevatorTalonLeft.set(-speed);
    elevatorTalonRight.set(speed);

  }

  public void driveLeft(double speed) {
    elevatorTalonLeft.set(-speed);

  }

  public void driveRight(double speed) {
    elevatorTalonRight.set(speed);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    // setDefaultCommand(new DriveElevatorCommand());
  }
}
