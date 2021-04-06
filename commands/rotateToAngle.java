// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.omniWheelDriveTrain;
import java.util.function.DoubleSupplier;
public class rotateToAngle extends CommandBase {
  private omniWheelDriveTrain m_drivetrainSubsystem;
  private DoubleSupplier m_angle;
  private boolean endNow = false;

  /** Creates a new rotateToAngle. */
  public rotateToAngle(omniWheelDriveTrain drivetrainSubsystem,DoubleSupplier angle) {
    m_drivetrainSubsystem = drivetrainSubsystem;
    m_angle = angle;
    // Use addRequirements() here to declare subsystem dependencies.
   addRequirements(m_drivetrainSubsystem); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putString("Angle Changing", "Running");
    if(m_drivetrainSubsystem.getValue() < m_angle.getAsDouble() -1){
      m_drivetrainSubsystem.rotate(()->-0.25);
    }else if(m_drivetrainSubsystem.getValue() > m_angle.getAsDouble() +1){
      m_drivetrainSubsystem.rotate(()->0.25);
    }else{
      endNow = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrainSubsystem.Go(()->0, ()->0,()->0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_drivetrainSubsystem.getValue() == m_angle.getAsDouble() || endNow == true){
      return true;
    }else{
      return false;
    }
  }
}
