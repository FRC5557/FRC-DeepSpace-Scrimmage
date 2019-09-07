/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.MotionProfiles;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.DistanceFollower;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 * Add your docs here.
 */
public class MotionProfile {

    Encoders encoder;

    SpeedControllerGroup leftMotors, rightMotors;

    double maxVel = 9.256463818; // Feet/second
    double maxAccl = 9.84251969; // Feet/second^2
    double maxJerk = 196.850394; // Feet/second^3
    Waypoint[] waypoints = new Waypoint[] { new Waypoint(5, 0, 0) };
    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH,
            0.05, maxVel, maxAccl, maxJerk);
    Trajectory trajectory = Pathfinder.generate(waypoints, config);
    // The distance between the left and right sides of the wheelbase is 0.6m
    double wheelbase_width = 0.6;
    Trajectory left;
    Trajectory right;

    // Create the Modifier Object
    TankModifier modifier = new TankModifier(trajectory);

    Notifier autoNotifier;

    DistanceFollower leftD, rightD;

    IMU gyro;

    public void main() {
        /**
         * Based on the examples provided in
         * https://github.com/JacisNonsense/Pathfinder/wiki/Pathfinder-for-FRC---Java#following-a-trajectory
         */

        WPI_TalonSRX leftFrontTalon = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
        WPI_TalonSRX rightFrontTalon = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
        WPI_TalonSRX leftRearTalon = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
        WPI_TalonSRX rightRearTalon = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);

        gyro = new IMU();

        leftMotors = new SpeedControllerGroup(leftFrontTalon, leftRearTalon);
        rightMotors = new SpeedControllerGroup(rightFrontTalon, rightRearTalon);

        modifier.modify(1.9191667);

        left = modifier.getLeftTrajectory(); // Get the Left Side
        right = modifier.getRightTrajectory(); // Get the Right Side

        DistanceFollower leftD = new DistanceFollower(left);
        DistanceFollower rightD = new DistanceFollower(right);
        leftD.configurePIDVA(1.0, 0.0, 0.6, 1 / maxVel, 0);
        rightD.configurePIDVA(1.0, 0.0, 0.3, 1 / maxVel, 0);

        autoNotifier = new Notifier(new RunAuton());
    }

    class RunAuton implements Runnable {
        @Override
        public void run() {
            if (!leftD.isFinished() || !rightD.isFinished()) {
                double l = leftD.calculate(encoder.getLeftDistanceFeet());
                double r = rightD.calculate(encoder.getRightDistanceFeet());

                double gyro_heading = gyro.getAngle();
                double desired_heading = Pathfinder.r2d(leftD.getHeading());

                double angleDifference = 0.8 * (-1.0 / 80.0)
                        * Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
                double turn = 0.8 * (-1.0 / 80.0) * angleDifference;

                System.out.println(l + turn);

                leftMotors.set(l + turn);
                rightMotors.set(r - turn);
            } else {
                leftMotors.set(0);
                rightMotors.set(0);
                autoNotifier.stop();
            }
        }
    }

}
