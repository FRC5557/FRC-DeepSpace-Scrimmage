package frc.robot.MotionProfiles;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This class handles the interface for the encoder hardware
 * 
 */
public class Encoders extends Subsystem {

    public static final int LEFT_ENCODER_A = 5;
    public static final int LEFT_ENCODER_B = 6;
    public static final int RIGHT_ENCODER_A = 7;
    public static final int RIGHT_ENCODER_B = 8;

    // Encoders
    public Encoder leftEncoder;
    public Encoder rightEncoder;

    // Variables
    double WHEEL_RADIUS = 3;
    double CIRCUMFRENCE = 2 * Math.PI * WHEEL_RADIUS;
    double PULSES_PER_REVOLUTION = 360;
    double distancePerPulse = CIRCUMFRENCE / PULSES_PER_REVOLUTION;

    public Encoders() {
        // Create encoders (channelA, channelB, inverted, encodingType(2x))
        leftEncoder = new Encoder(LEFT_ENCODER_A, LEFT_ENCODER_B, true, EncodingType.k2X);
        rightEncoder = new Encoder(RIGHT_ENCODER_A, RIGHT_ENCODER_B, false, EncodingType.k2X);
        // Set distance per pulse (CIRCUMFERENCE / PPR)
        leftEncoder.setDistancePerPulse(distancePerPulse);
        rightEncoder.setDistancePerPulse(distancePerPulse);
    }

    /**
     * Get the count of the encoders
     * 
     * @return pulses of encoders
     */
    public int getLeftCount() {
        return leftEncoder.get();
    }

    public int getRightCount() {
        return rightEncoder.get();
    }

    /**
     * Convert the count of the encoders to inches
     * 
     * @return inches traveled
     */
    public double getLeftDistanceInches() {
        return leftEncoder.getDistance();
    }

    public double getRightDistanceInches() {
        return rightEncoder.getDistance();
    }

    /**
     * Convert the count of the encoders to feet
     * 
     * @return feet traveled
     */
    public double getLeftDistanceFeet() {
        return leftEncoder.getDistance() / 12;
    }

    public double getRightDistanceFeet() {
        return rightEncoder.getDistance() / 12;
    }

    /**
     * Reset methods
     * 
     */
    public void resetLeftEncoder() {
        leftEncoder.reset();
    }

    public void resetRightEncoder() {
        rightEncoder.reset();
    }

    public void reset() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    @Override
    public void initDefaultCommand() {
        // Do nothing
    }
}