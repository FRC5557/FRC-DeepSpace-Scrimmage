/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchPneumaticSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static HatchPneumaticSubsystem instance = null;

  DoubleSolenoid hatchSolenoid = new DoubleSolenoid(RobotMap.EXTEND_HATCH_PORT, RobotMap.RETRACT_HATCH_PORT);

  public static HatchPneumaticSubsystem getInstance() {
    if(instance == null) {
      instance = new HatchPneumaticSubsystem();
    }
    return instance;
  }

  public void extendHatch() {
    hatchSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retractHatch() {
    hatchSolenoid.set(DoubleSolenoid.Value.kReverse);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
