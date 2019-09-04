/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 * Add your docs here.
 */
public class MotionProfile {
    public static void main() {
        /**
         * Based on the examples provided in
         * https://github.com/JacisNonsense/Pathfinder/wiki/Pathfinder-for-FRC---Java#following-a-trajectory
         */

        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
                Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
        Waypoint[] points = new Waypoint[] { new Waypoint(-4, -1, Pathfinder.d2r(-45)), new Waypoint(-2, -2, 0),
                new Waypoint(0, 0, 0) };

        Trajectory trajectory = Pathfinder.generate(points, config);

        // Wheelbase Width = 0.5m
        TankModifier modifier = new TankModifier(trajectory).modify(0.5);

        EncoderFollower left = new EncoderFollower(modifier.getLeftTrajectory());
        EncoderFollower right = new EncoderFollower(modifier.getRightTrajectory());

        WPI_TalonSRX leftFrontTalon = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
        WPI_TalonSRX rightFrontTalon = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);

        // Encoder Position is the current, cumulative position of your encoder. If
        // you're using an SRX, this will be the
        // 'getEncPosition' function.
        // 1000 is the amount of encoder ticks per full revolution
        // Wheel Diameter is the diameter of your wheels (or pulley for a track system)
        // in meters
        left.configureEncoder(leftFrontTalon.getSensorCollection().getPulseWidthPosition(), 1000, 0.5);

        // The first argument is the proportional gain. Usually this will be quite high
        // The second argument is the integral gain. This is unused for motion profiling
        // The third argument is the derivative gain. Tweak this if you are unhappy with
        // the tracking of the trajectory
        // The fourth argument is the velocity ratio. This is 1 over the maximum
        // velocity you provided in the
        // trajectory configuration (it translates m/s to a -1 to 1 scale that your
        // motors can read)
        // The fifth argument is your acceleration gain. Tweak this if you want to get
        // to a higher or lower speed quicker
        left.configurePIDVA(1.0, 0.0, 0.0, 1 / 0.7, 0);

        /*
         * This section us for calculating the different left and right values and
         * adjusting based on a gyro value to adjust for curving
         */

        // double l = left.calculate(encoder_position_left);
        // double r = right.calculate(encoder_position_right);

        // double gyro_heading = ... your gyro code here ... // Assuming the gyro is
        // giving a value in degrees
        // double desired_heading = Pathfinder.r2d(left.getHeading()); // Should also be
        // in degrees

        // // This allows the angle difference to respect 'wrapping', where 360 and 0
        // are the same value
        // double angleDifference = Pathfinder.boundHalfDegrees(desired_heading -
        // gyro_heading);
        // angleDifference = angleDifference % 360.0;
        // if (Math.abs(angleDifference) > 180.0) {
        // angleDiff = (angleDifference > 0) ? angleDifference - 360 : angleDiff + 360;
        // }

        // double turn = 0.8 * (-1.0/80.0) * angleDifference;

        // setLeftMotors(l + turn);
        // setRightMotors(r - turn);

        // Do something with the new Trajectories...
        // Trajectory left = modifier.getLeftTrajectory();
        // Trajectory right = modifier.getRightTrajectory();

    }

}
