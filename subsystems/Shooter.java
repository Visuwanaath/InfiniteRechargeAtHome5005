// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  public Shooter() {}
  private Spark leftShooter = new Spark(Constants.shooterLeft);
  private Spark rightShooter = new Spark(Constants.shooterRight);
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void shoot(){
    leftShooter.set(-0.6 * -1);
    rightShooter.set(0.6);
  }
  public void stopShoot(){
    leftShooter.set(0);
    rightShooter.set(0);
  }
}
