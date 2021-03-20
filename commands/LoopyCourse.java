// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.omniWheelDriveTrain;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LoopyCourse extends SequentialCommandGroup {
  /** Creates a new LoopyCourse. */
  public LoopyCourse(omniWheelDriveTrain driveTrainSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //forward is 90 //forward is 90
      new resetEncoders(driveTrainSubsystem,()->true,()->true),
      new driveByGyro(driveTrainSubsystem, ()->90, ()->5500,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->180, ()->7000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->90, ()->20000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->0, ()->7800,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->90, ()->6500,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->180, ()->7000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->270, ()->6000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->0, ()->7000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->270, ()->25000,()->-5),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->180, ()->7000,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByGyro(driveTrainSubsystem, ()->270, ()->5000,()->0)

      /*
      new resetEncoders(driveTrainSubsystem,()->true,()->true),
      new driveByEncoders(driveTrainSubsystem, ()->90,()-> 5500),
      //new autoDrive(driveTrainSubsystem, ()->0, ()->0).withTimeout(1),
      
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->180,()-> 8000),
      //new autoDrive(driveTrainSubsystem, ()->0, ()->0).withTimeout(1,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new rotateToAngle(driveTrainSubsystem, ()->0,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->90,()-> 20000),
      //new autoDrive(driveTrainSubsystem, ()->0, ()->0).withTimeout(1),
      new rotateToAngle(driveTrainSubsystem, ()->0,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->0,()-> 7800),
      //new autoDrive(driveTrainSubsystem, ()->0, ()->0).withTimeout(1),
      new rotateToAngle(driveTrainSubsystem, ()->0,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->90,()-> 6500),
      //new autoDrive(driveTrainSubsystem, ()->0, ()->0).withTimeout(1),
      new rotateToAngle(driveTrainSubsystem, ()->0,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      //new autoDrive(driveTrainSubsystem, ()->0, ()->0).withTimeout(1),
      new driveByEncoders(driveTrainSubsystem, ()->180,()-> 7000),
      new rotateToAngle(driveTrainSubsystem, ()->0,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->270,()-> 6000),
      new rotateToAngle(driveTrainSubsystem, ()->0,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->0,()-> 7000),
      new rotateToAngle(driveTrainSubsystem, ()->0,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->270,()-> 5000),
      //new rotateToAngle(driveTrainSubsystem, ()->-10,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->270,()-> 5000),
      //new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-10,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->270,()-> 5000),
      //new rotateToAngle(IMUsubsystem,driveTrainSubsystem, ()->-10,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->270,()-> 5000),
      new rotateToAngle(driveTrainSubsystem, ()->0,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->180,()-> 7000),
      new rotateToAngle(driveTrainSubsystem, ()->0,()->0),
      new resetEncoders(driveTrainSubsystem,()->true,()->false),
      new driveByEncoders(driveTrainSubsystem, ()->270,()-> 5000),
      new rotateToAngle(driveTrainSubsystem, ()->45)
      */
      
    );
  }
}
