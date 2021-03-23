// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.leftShooter;
import frc.robot.subsystems.rightShooter;
public class getShooterToSpeed extends CommandBase {
  rightShooter m_rightShooter;
  leftShooter m_leftShooter;
  Boolean m_stopWhenCommandEnds;
  double m_speed;
  /** Creates a new getShooterToSpeed. */
  public getShooterToSpeed(leftShooter leftShooter,rightShooter rightShooter,DoubleSupplier speed, BooleanSupplier stopWhenCommandEnds) {
    m_rightShooter = rightShooter;
    m_leftShooter = leftShooter;
    m_stopWhenCommandEnds = stopWhenCommandEnds.getAsBoolean();
    m_speed = speed.getAsDouble();
    addRequirements(m_leftShooter);
    addRequirements(m_rightShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_rightShooter.setSetpoint(50);
    m_leftShooter.setSetpoint(-50);
    if(m_rightShooter.isEnabled() == false){
      m_rightShooter.enable();
    }
    if(m_leftShooter.isEnabled() == false){
      m_leftShooter.enable();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(m_stopWhenCommandEnds == true){
      m_leftShooter.disable();
      m_rightShooter.disable();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
