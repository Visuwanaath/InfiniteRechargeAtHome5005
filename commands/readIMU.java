// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IMU;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class readIMU extends CommandBase {
  IMU m_IMU;
  /** Creates a new readIMU. */
  public readIMU(IMU subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_IMU = subsystem;
    addRequirements(m_IMU);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Value",m_IMU.getValue());
    SmartDashboard.putNumber("X Value",m_IMU.getXValue());
    SmartDashboard.putNumber("Y Angle",m_IMU.getYValue());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
