// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.omniWheelDriveTrain;
import java.util.function.DoubleSupplier;
public class driveWithRawValues extends CommandBase {
  private omniWheelDriveTrain m_drivetrainSubsystem;
  private DoubleSupplier m_north;
  private DoubleSupplier m_east;
  private DoubleSupplier m_south;
  private DoubleSupplier m_west;
  /** Creates a new driveWithRawValues. */
  public driveWithRawValues(omniWheelDriveTrain subsystem,DoubleSupplier northSupplier,DoubleSupplier eastSupplier, DoubleSupplier southSupplier, DoubleSupplier westSupplier) {
    m_drivetrainSubsystem = subsystem;
    m_north = northSupplier;
    m_east = eastSupplier;
    m_south = southSupplier;
    m_west = westSupplier;
    addRequirements(m_drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrainSubsystem.setSpeedsRaw(m_north, m_east, m_south,m_west);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrainSubsystem.Go(()->0, ()->0,()->0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
