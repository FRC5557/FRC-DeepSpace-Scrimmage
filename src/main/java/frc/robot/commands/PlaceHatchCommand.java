/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class PlaceHatchCommand extends Command {
  public PlaceHatchCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    // this will need to require the pneumatic / hatch arm subsystem
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // make sure the hatch arm is open so that hatch doesnt fall out
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // TODO: set the hatch to close to place the hatch
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // return true so that the command only runs once :D
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // possibly retract the hatch or some sort of action
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
