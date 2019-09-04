/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveTowardsHatchCommand;
import frc.robot.commands.PlaceHatchCommand;

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
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:
  JoystickButton placeHatchButton;
  JoystickButton toggleAutoDrive;
  JoystickButton toggleControllerDrive;
  DriveTowardsHatchCommand hatchCommand;
  DriveCommand driveCommand;

  public OI() {
    stick = new Joystick(RobotMap.JOYSTICK_PORT);

    placeHatchButton = new JoystickButton(stick, RobotMap.X_BUTTON);
    toggleAutoDrive = new JoystickButton(stick, RobotMap.X_BUTTON);
    toggleControllerDrive = new JoystickButton(stick, RobotMap.X_BUTTON);
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    placeHatchButton.whenPressed(new PlaceHatchCommand());

    hatchCommand = new DriveTowardsHatchCommand();
    driveCommand = new DriveCommand();

    // TODO: test this to see if it toggles and such
    // TODO: turn on limelight lights only when in limelight mode
    toggleAutoDrive.whenPressed(hatchCommand);
    toggleAutoDrive.cancelWhenPressed(driveCommand);

    toggleControllerDrive.whenPressed(driveCommand);
    toggleControllerDrive.cancelWhenPressed(hatchCommand);
    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
  }
}
