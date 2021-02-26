// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
public class Loader extends SubsystemBase {
  /** Creates a new Loader. */
  public Loader() {}
  private Spark loader = new Spark(Constants.loaderPWM);
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void load(){
    loader.set(-1);
  }
  public void stopLoad(){
    loader.set(0);
  }
}
