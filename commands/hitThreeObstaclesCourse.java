// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.omniWheelDriveTrain;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class hitThreeObstaclesCourse extends SequentialCommandGroup {
  /** Creates a new hitThreeObstaclesCourse. */
  public hitThreeObstaclesCourse(omniWheelDriveTrain driveTrainSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new resetEncoders(driveTrainSubsystem,()->true,()->true),
      new driveByGyro(driveTrainSubsystem, ()->90, ()->5000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->180, ()->5000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->0, ()->5000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->90, ()->3000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->0, ()->6000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->90, ()->5500,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->180, ()->13000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->0, ()->13000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->90, ()->10000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->180, ()->13000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->0, ()->6000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->90, ()->5000,()->0)
    );
  }
}
