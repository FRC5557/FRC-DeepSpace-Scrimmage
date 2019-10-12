/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static DriveSubsystem instance = null;

  private final WPI_TalonSRX leftFrontTalon;
  private final WPI_TalonSRX rightFrontTalon;
  private final WPI_TalonSRX leftRearTalon;
  private final WPI_TalonSRX rightRearTalon;

  private final SpeedControllerGroup leftGroup;
  private final SpeedControllerGroup rightGroup;
  private final DifferentialDrive difDrive;

  // https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/Encoder.html
  // private final Encoder mLeftEncoder, mRightEncoder;

  public static DriveSubsystem getInstance() {
    if (instance == null) {
      instance = new DriveSubsystem();
    }
    return instance;
  }

  private DriveSubsystem() {
    leftFrontTalon = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
    rightFrontTalon = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_MOTOR);
    leftRearTalon = new WPI_TalonSRX(RobotMap.LEFT_REAR_MOTOR);
    rightRearTalon = new WPI_TalonSRX(RobotMap.RIGHT_REAR_MOTOR);

    leftGroup = new SpeedControllerGroup(leftFrontTalon, leftRearTalon);
    rightGroup = new SpeedControllerGroup(rightFrontTalon, rightRearTalon);
    difDrive = new DifferentialDrive(leftGroup, rightGroup);

    difDrive.setSafetyEnabled(false);
    // possible mehcanum drive
    // https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599704-driving-a-robot-using-mecanum-drive
    // MecanumDrive x = new MecanumDrive(leftFrontTalon, leftRearTalon,
    // rightFrontTalon, rightRearTalon);
  }

  public void drive(double turn, double throttle) {
		difDrive.arcadeDrive(throttle,turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }
}
