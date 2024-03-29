/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ExtendHabCommand;
import frc.robot.commands.MoveHabBackCommand;
import frc.robot.commands.MoveHabForwardCommand;
import frc.robot.commands.RetractHabCommand;
import frc.robot.commands.TestElevatorLeftCommand;
import frc.robot.commands.TestElevatorRightCommand;
import frc.robot.commands.extendHatchCommand;
import frc.robot.commands.retractHatchCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  public Joystick stick;
  // public Joystick stick2;
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:
  JoystickButton extendHatchButton;
  JoystickButton retractHatchButton;

  JoystickButton moveHabForwardButton;
  JoystickButton moveHabBackButton;

  JoystickButton extendHabButton;
  JoystickButton retractHabButton;

  JoystickButton testElevatorLeftButton;
  JoystickButton testElevatorRightButton;

  public OI() {
    // ps4 controller
    stick = new Joystick(RobotMap.JOYSTICK_PORT);
    // joystick
    // stick2 = new Joystick(RobotMap.JOYSTICK_PORT_2);

    extendHatchButton = new JoystickButton(stick, RobotMap.X_BUTTON);
    retractHatchButton = new JoystickButton(stick, RobotMap.CIRCLE_BUTTON);

    extendHatchButton.whenPressed(new extendHatchCommand());
    retractHatchButton.whenPressed(new retractHatchCommand());

    moveHabForwardButton = new JoystickButton(stick, RobotMap.R1);
    moveHabForwardButton.whileHeld(new MoveHabForwardCommand());

    moveHabBackButton = new JoystickButton(stick, RobotMap.R2);
    moveHabBackButton.whileHeld(new MoveHabBackCommand());

    extendHabButton = new JoystickButton(stick, RobotMap.TRIANGLE_BUTTON);
    extendHabButton.whenPressed(new ExtendHabCommand());

    retractHabButton = new JoystickButton(stick, RobotMap.SQUARE_BUTTON);
    retractHabButton.whenPressed(new RetractHabCommand());

    testElevatorLeftButton = new JoystickButton(stick, RobotMap.DPAD_LEFT);
    testElevatorLeftButton.whileHeld(new TestElevatorLeftCommand());

    testElevatorRightButton = new JoystickButton(stick, RobotMap.DPAD_RIGHT);
    testElevatorRightButton.whileHeld(new TestElevatorRightCommand());

    // placeHatchButton = new JoystickButton(stick, RobotMap.X_BUTTON);
    // toggleAutoDrive = new JoystickButton(stick, RobotMap.A_BUTTON);
    // toggleControllerDrive = new JoystickButton(stick, RobotMap.B_BUTTON);
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // placeHatchButton.whenPressed(new PlaceHatchCommand());

    // hatchCommand = new DriveTowardsHatchCommand();
    // driveCommand = new DriveCommand();

    // TODO: test this to see if it toggles and such
    // TODO: turn on limelight lights only when in limelight mode
    // toggleAutoDrive.whenPressed(hatchCommand);
    // toggleAutoDrive.cancelWhenPressed(driveCommand);

    // toggleControllerDrive.whenPressed(driveCommand);
    // toggleControllerDrive.cancelWhenPressed(hatchCommand);
    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
  }
}
