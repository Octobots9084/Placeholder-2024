// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MatBuilder;
import edu.wpi.first.math.Matrix;
import edu.wpi.first.math.Nat;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N3;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;
import swervelib.parser.PIDFConfig;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be
 * declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final double ROBOT_MASS = (65) * 0.453592; // 32lbs * kg per pound
  public static final Matter CHASSIS = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final double LOOP_TIME = 0.13; // s, 20ms + 110ms sprk max velocity lag

  public static final class Auton {

    public static final PIDFConfig TranslationPID = new PIDFConfig(0.7, 0, 0);
    public static final PIDFConfig angleAutoPID = new PIDFConfig(0.4, 0, 0.01);

    public static final double MAX_ACCELERATION = 2;
  }

  public static final class Drivebase {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  }

  public static class OperatorConstants {

    // Joystick Deadband
    public static final double LEFT_X_DEADBAND = 0.01;
    public static final double LEFT_Y_DEADBAND = 0.01;
    public static final double RIGHT_X_DEADBAND = 0.01;
    public static final double TURN_CONSTANT = 6;
  }

  public static class FieldConstants {
    public static final double length = Units.feetToMeters(54);
    public static final double width = Units.feetToMeters(27);
  }

  public static final class VisionConstants {

    public static boolean USE_VISION = true;

    /**
     * Physical location of the front right camera on the robot, relative to the center of
     * the
     * robot.
     */
    public static final Transform3d ROBOT_TO_FRONT_RIGHT_CAMERA = new Transform3d(
        new Translation3d(Units.inchesToMeters(-11), Units.inchesToMeters(-11),
            Units.inchesToMeters(22.5)),
        new Rotation3d(0, Math.toRadians(0), Math.toRadians(0)));

    /**
     * Physical location of the front left camera on the robot, relative to the center of
     * the
     * robot.
     */
    public static final Transform3d ROBOT_TO_FRONT_LEFT_CAMERA = new Transform3d(
        new Translation3d(Units.inchesToMeters(11), Units.inchesToMeters(-11),
            Units.inchesToMeters(22.5)),
        new Rotation3d(0, Math.toRadians(0), Math.toRadians(0)));

    /**
     * Physical location of the back right camera on the robot, relative to the center of
     * the
     * robot.
     */
    public static final Transform3d ROBOT_TO_BACK_RIGHT_CAMERA = new Transform3d(
        new Translation3d(Units.inchesToMeters(-13.76), Units.inchesToMeters(6.1),
            Units.inchesToMeters(33.65)),
        new Rotation3d(0, Math.toRadians(10.62), Math.toRadians(180)));

    /**
     * Physical location of the back left camera on the robot, relative to the center of
     * the
     * robot.
     */
    public static final Transform3d ROBOT_TO_BACK_LEFT_CAMERA = new Transform3d(
        new Translation3d(Units.inchesToMeters(-13.76), Units.inchesToMeters(6.1),
            Units.inchesToMeters(33.65)),
        new Rotation3d(0, Math.toRadians(10.62), Math.toRadians(180)));

    /** Minimum target ambiguity. Targets with higher ambiguity will be discarded */
    public static final double APRILTAG_AMBIGUITY_THRESHOLD = 0.2;
    public static final double POSE_AMBIGUITY_SHIFTER = 0.2;
    public static final double POSE_AMBIGUITY_MULTIPLIER = 4;
    public static final double NOISY_DISTANCE_METERS = 2.5;
    public static final double DISTANCE_WEIGHT = 7;
    public static final int TAG_PRESENCE_WEIGHT = 10;

    /**
     * Standard deviations of model states. Increase these numbers to trust your
     * model's state estimates less. This
     * matrix is in the form [x, y, theta]ᵀ, with units in meters and radians, then
     * meters.
     * If these numbers are less than one, multiplying will do bad things
     */

    public static final Matrix<N3, N1> VISION_MEASUREMENT_STANDARD_DEVIATIONS = MatBuilder.fill(Nat.N3(),
        Nat.N1(), 1, // x
        1, // y
        1 * Math.PI); // theta

    /**
     * Standard deviations of the vision measurements. Increase these numbers to
     * trust global measurements from vision
     * less. This matrix is in the form [x, y, theta]ᵀ, with units in meters and
     * radians.
     * If these numbers are less than one, multiplying will do bad things
     */
    public static final Matrix<N3, N1> STATE_STANDARD_DEVIATIONS = MatBuilder.fill(Nat.N3(), Nat.N1(),
        .1, // x
        .1, // y 
        .1);

  }
}