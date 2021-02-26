// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.omniWheelDriveTrain;
import java.util.function.DoubleSupplier;
public class defaultDrive extends CommandBase {
  /** Creates a new defaultDrive. */
  private omniWheelDriveTrain m_drivetrainSubsystem;
  private DoubleSupplier m_X;
  private DoubleSupplier m_Y;
  private DoubleSupplier m_Rot;
  public defaultDrive(omniWheelDriveTrain subsystem,DoubleSupplier X,DoubleSupplier Y,DoubleSupplier Rot) {
    // Use addRequirements() here to declare subsystem dependencies.
  m_drivetrainSubsystem = subsystem;
  m_X = X;
  m_Y = Y;
  m_Rot = Rot;
  addRequirements(m_drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrainSubsystem.Go(m_X, m_Y,m_Rot);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrainSubsystem.Go(()->0,()-> 0,()-> 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
