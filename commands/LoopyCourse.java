// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.omniWheelDriveTrain;
import frc.robot.subsystems.IMU;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LoopyCourse extends SequentialCommandGroup {
  /** Creates a new LoopyCourse. */
  public LoopyCourse(omniWheelDriveTrain driveTrainSubsystem,IMU IMUsubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //forward is 90

      new autoDrive(driveTrainSubsystem, ()->100, ()->0.6).withTimeout(1.53),
      new autoDrive(driveTrainSubsystem, ()->175, ()->0.4).withTimeout(2),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->0),
      new autoDrive(driveTrainSubsystem, ()->180, ()->0.4).withTimeout(2.2),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->0),
      new autoDrive(driveTrainSubsystem, ()->0, ()->0).withTimeout(1),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(1),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->20),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(1),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->20),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(1),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->20),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(1),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->15),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(1),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->20),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(1),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->15),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(0.7),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->20),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-80),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(2.1),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->0),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(1.5),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->80),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(2.5),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->180),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(2.4),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-90),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(2.4),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-180),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(0.9),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-165),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(0.9),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-165),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(0.9),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-165),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(0.9),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-165),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(0.9),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-165),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(0.9),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-165),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(0.9),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-170),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(0.5),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-170),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-270),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(1.75),
      new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-190),
      new autoDrive(driveTrainSubsystem, ()->90, ()->0.5).withTimeout(2.2)
      //new autoDrive(driveTrainSubsystem, ()->110, ()->0.5).withTimeout(4.25),
      //new autoDrive(driveTrainSubsystem, ()->90, ()->0.8).withTimeout(1.3)
      //new autoDrive(driveTrainSubsystem, ()->90, ()->0.8).withTimeout(0.8),
      //new autoDrive(driveTrainSubsystem, ()->180, ()->0.8).withTimeout(0.8),
      //new autoDrive(driveTrainSubsystem, ()->270, ()->0.8).withTimeout(0.8),
      //new autoDrive(driveTrainSubsystem, ()->0, ()->0.8).withTimeout(0.8),
      //new autoDrive(driveTrainSubsystem, ()->270, ()->1).withTimeout(1)
    );
  }
}
