// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.omniWheelDriveTrain;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class driveByEncoders extends CommandBase {
  private omniWheelDriveTrain m_drivetrainSubsystem;
  private DoubleSupplier m_angle;
  private DoubleSupplier m_counts;
  /** Creates a new driveByEncoders. */
  public driveByEncoders(omniWheelDriveTrain subsystem, DoubleSupplier angle,DoubleSupplier counts) {
    m_drivetrainSubsystem = subsystem;
    m_angle = angle;
    m_counts = counts;
    addRequirements(m_drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double gyroErrorConstant = 100;
    double gyroError = m_drivetrainSubsystem.getValue();
    double gyroErrorRange = 1;
    if(m_angle.getAsDouble() == 90){
      double speed = 0.4;
      double error = m_drivetrainSubsystem.getEncoderDistance(1) - m_drivetrainSubsystem.getEncoderDistance(3);
      SmartDashboard.putNumber("Encoder Drive Error", error);
      error = error/2000;
      double southSpeed = speed*-1;
      double northSpeed = speed;
      double westSpeed;
      if(gyroError >gyroErrorRange){
        westSpeed = 0.35;
      }else if(gyroError < gyroErrorRange * -1){
        westSpeed = -0.35;
      }else{
        westSpeed = 0;
      }
      m_drivetrainSubsystem.setSpeedsRaw(()->northSpeed,()->westSpeed,()->southSpeed,()->0);
    }else if(m_angle.getAsDouble() == 180){
      double speed = -0.35;
      double speed2 = 0.35;
      double error = m_drivetrainSubsystem.getEncoderDistance(2) - m_drivetrainSubsystem.getEncoderDistance(4)*-1;
      SmartDashboard.putNumber("Encoder Drive Error", error);
      error = error/1000;
      double eastSpeed = speed2 + error;
      double westSpeed = speed;
      double northSpeed;
      if(gyroError >gyroErrorRange){
        northSpeed = 0.35;
      }else if(gyroError < gyroErrorRange * -1){
        northSpeed = -0.35;
      }else{
        northSpeed = 0;
      }
      m_drivetrainSubsystem.setSpeedsRaw(()->northSpeed,()->westSpeed,()->0,()->eastSpeed);
    }else if(m_angle.getAsDouble() == 0){
      double speed = 0.35;
      double speed2 = -0.35;
      double error = m_drivetrainSubsystem.getEncoderDistance(2) - m_drivetrainSubsystem.getEncoderDistance(4)*-1;
      SmartDashboard.putNumber("Encoder Drive Error", error);
      error = error/1000;
      double eastSpeed = speed2 + error;
      double westSpeed = speed;
      double northSpeed;
      if(gyroError >gyroErrorRange){
        northSpeed = 0.35;
      }else if(gyroError < gyroErrorRange * -1){
        northSpeed = -0.35;
      }else{
        northSpeed = 0;
      }
      m_drivetrainSubsystem.setSpeedsRaw(()->northSpeed,()->westSpeed,()->0,()->eastSpeed);
    }else if(m_angle.getAsDouble() == 270){
      double speed = -0.35;
      double error = m_drivetrainSubsystem.getEncoderDistance(1) - m_drivetrainSubsystem.getEncoderDistance(3);
      SmartDashboard.putNumber("Encoder Drive Error", error);
      error = error/2000;
      double southSpeed = speed*-1 - error;
      double northSpeed = speed;
      double westSpeed;
      if(gyroError >gyroErrorRange){
        westSpeed = 0.35;
      }else if(gyroError < gyroErrorRange * -1){
        westSpeed = -0.35;
      }else{
        westSpeed = 0;
      }
      m_drivetrainSubsystem.setSpeedsRaw(()->northSpeed,()->westSpeed,()->southSpeed,()->0);
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
      if(Math.abs(m_drivetrainSubsystem.getEncoderDistance(3)) >= m_counts.getAsDouble()){
        return true;
      }
    }else if(m_angle.getAsDouble() == 180){
      if(Math.abs(m_drivetrainSubsystem.getEncoderDistance(4)) >= m_counts.getAsDouble()){
        return true;
      }
    }else if(m_angle.getAsDouble() == 270){
      if(Math.abs(m_drivetrainSubsystem.getEncoderDistance(3)) >= m_counts.getAsDouble()){
        return true;
      }
    }
      return false;
  }
}
