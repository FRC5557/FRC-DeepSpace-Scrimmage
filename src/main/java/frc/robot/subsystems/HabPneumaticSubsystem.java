/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HabPneumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static HabPneumaticSubsystem instance = null;

  DoubleSolenoid habSolenoid = new DoubleSolenoid(RobotMap.HAB_SOLENOID_PORT_1, RobotMap.HAB_SOLENOID_PORT_2);

  public static HabPneumaticSubsystem getInstance() {
    if(instance == null) {
      instance = new HabPneumaticSubsystem();
    }
    return instance;
  }

  public void extendHab() {
    habSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retractHab() {
    habSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
