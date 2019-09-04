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
  public DriveForDistance() {
    // pass in desired distance or encoder value

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(DriveSubsystem.getInstance());
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // reset encoder values
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // add constant driving code here
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // grab current encoder value
    // write logic here to calculate if the desired encoder value - current encoder
    // value <= 0
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
