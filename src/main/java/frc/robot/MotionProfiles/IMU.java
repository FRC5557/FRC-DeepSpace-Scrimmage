package frc.robot.MotionProfiles;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This class is the interface to the IMU hardware
 * 
 */
public class IMU extends Subsystem {

    // Create IMU
    public AHRS ahrs;

    // Cumulative turning heading
    public double cumulativeCommandedHeading = 0.0;

    public IMU() {
        try {
            // Initialize IMU
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (Exception e) {
            System.out.println("IMU failed to connect");
        }
    }

    public float getAngle() {
        return (float) ahrs.getAngle();
    }

    /**
     * Use this to get the current heading
     * 
     * @return the degrees - is left + is right
     */
    public float getHeading() {
        return ahrs.getYaw();
    }

    /**
     * This resets the IMU
     * 
     */
    public void reset() {
        ahrs.reset();
    }

    @Override
    public void initDefaultCommand() {

    }

}