/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
  public static int JOYSTICK_PORT = 0;

  // Motor controllers are mapped here
  public static final int LEFT_REAR_MOTOR = 4; // Encoder on this one, counts down when driving forward
  public static final int LEFT_FRONT_MOTOR = 3;
  public static final int RIGHT_FRONT_MOTOR = 2;// Encoder on this one, counts up when driving forward
  public static final int RIGHT_REAR_MOTOR = 1;


  // XBOX CONTROLLER STUFF
  public static final int X_BUTTON = 3; // X
  public static final int Y_BUTTON = 4; // X
  public static final int A_BUTTON = 1; // X
  public static final int B_BUTTON = 2; // X


  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

}
