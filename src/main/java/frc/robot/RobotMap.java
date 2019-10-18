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
  public static int JOYSTICK_PORT_2 = 1;

  // Motor controllers are mapped here
  public static final int LEFT_REAR_MOTOR = 4; // Encoder on this one, counts down when driving forward
  public static final int LEFT_FRONT_MOTOR = 3;
  public static final int RIGHT_FRONT_MOTOR = 2;// Encoder on this one, counts up when driving forward
  public static final int RIGHT_REAR_MOTOR = 1;

  // PS4 CONTROLLER STUFF
  public static final int X_BUTTON = 2; // X
  public static final int CIRCLE_BUTTON = 3; // X
  public static final int TRIANGLE_BUTTON = 4; // X
  public static final int SQUARE_BUTTON = 1; // X6;

  public static final int DPAD_LEFT = 11;
  public static final int DPAD_RIGHT = 12;

  public static final int R1 = 6;
  public static final int R2 = 5;

  public static final int ELEVATOR_MOTOR_LEFT = 5;
  public static final int ELEVATOR_MOTOR_RIGHT = 8;

  public static final int HAB_MOTOR_1 = 7;
  public static final int HAB_MOTOR_2 = 6;

  public static final int COMPRESSOR_PORT = 0;

  public static final int EXTEND_HATCH_PORT = 0;
  public static final int RETRACT_HATCH_PORT = 1;

  public static final int HAB_SOLENOID_PORT_1 = 2;
  public static final int HAB_SOLENOID_PORT_2 = 3;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

}
