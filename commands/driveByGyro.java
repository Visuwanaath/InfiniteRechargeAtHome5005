// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.omniWheelDriveTrain;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class driveByGyro extends CommandBase {
  private omniWheelDriveTrain m_drivetrainSubsystem;
  private DoubleSupplier m_angle;
  private DoubleSupplier m_counts;
  private DoubleSupplier m_gyroAngle;
  /** Creates a new driveByGyro. */
  public driveByGyro(omniWheelDriveTrain subsystem, DoubleSupplier angle,DoubleSupplier counts,DoubleSupplier gyroAngle) {
    m_drivetrainSubsystem = subsystem;
    m_angle = angle;
    m_counts = counts;
    m_gyroAngle = gyroAngle;
    addRequirements(m_drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double gyroErrorConstant = 20;
    double gyroError = m_drivetrainSubsystem.getValue() - m_gyroAngle.getAsDouble();
    double gyroErrorRange = 1;
    if(m_angle.getAsDouble() == 90){
      double speed = 0.4;
      double southSpeed = speed*-1 + gyroError/gyroErrorConstant;
      double northSpeed = speed;
      m_drivetrainSubsystem.setSpeedsRaw(()->northSpeed,()->0,()->southSpeed,()->0);
    }else if(m_angle.getAsDouble() == 180){
      double speed = -0.4;
      double speed2 = 0.4;
      double eastSpeed = speed2 + gyroError/gyroErrorConstant;
      double westSpeed = speed;
      m_drivetrainSubsystem.setSpeedsRaw(()->0,()->westSpeed,()->0,()->eastSpeed);
    }else if(m_angle.getAsDouble() == 0){
      double speed = 0.4;
      double speed2 = -0.4;
      double eastSpeed = speed2 + gyroError/gyroErrorConstant;
      double westSpeed = speed;
      m_drivetrainSubsystem.setSpeedsRaw(()->0,()->westSpeed,()->0,()->eastSpeed);
    }else if(m_angle.getAsDouble() == 270){
      double speed = -0.4;
      double southSpeed = speed*-1 + gyroError/gyroErrorConstant;
      double northSpeed = speed;
      m_drivetrainSubsystem.setSpeedsRaw(()->northSpeed,()->0,()->southSpeed,()->0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrainSubsystem.setSpeedsRaw(()->0, ()->0, ()->0, ()->0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  if(m_angle.getAsDouble() == 0){
    if(Math.abs(m_drivetrainSubsystem.getEncoderDistance(4)) >= m_counts.getAsDouble()){
      return true;
    }
  }else if(m_angle.getAsDouble() == 90){
    if(Math.abs(m_drivetrainSubsystem.getEncoderDistance(1)) >= m_counts.getAsDouble()){
      return true;
    }
  }else if(m_angle.getAsDouble() == 180){
    if(Math.abs(m_drivetrainSubsystem.getEncoderDistance(4)) >= m_counts.getAsDouble()){
      return true;
    }
  }else if(m_angle.getAsDouble() == 270){
    if(Math.abs(m_drivetrainSubsystem.getEncoderDistance(1)) >= m_counts.getAsDouble()){
      return true;
    }
  }
    return false;
  }
}
