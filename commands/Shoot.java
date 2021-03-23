// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.leftShooter;
import frc.robot.subsystems.rightShooter;
public class Shoot extends CommandBase {
  /** Creates a new Shoot. */
  private leftShooter m_leftShooter;
  private rightShooter m_rightShooter;
  private DoubleSupplier m_speed;
  public Shoot(leftShooter leftShooter,rightShooter rightShooter,DoubleSupplier speed) {
    m_leftShooter = leftShooter;
    m_rightShooter = rightShooter;
    m_speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_rightShooter);
    addRequirements(m_leftShooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_leftShooter.setSpeed(m_speed);
    double negativeSpeed = m_speed.getAsDouble() * -1;
    m_rightShooter.setSpeed(()->negativeSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_leftShooter.setSpeed(()->0);
    m_rightShooter.setSpeed(()->0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
