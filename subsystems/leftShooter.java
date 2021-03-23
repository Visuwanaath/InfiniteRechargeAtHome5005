// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.ArrayList;
import java.util.function.DoubleSupplier;
public class leftShooter extends PIDSubsystem {
  private Encoder leftShooterEncoder = new Encoder(8,9);
  private Spark leftShooter = new Spark(Constants.shooterLeft);
  ArrayList<Double> AverageValues = new ArrayList<Double>(5);
  double AverageValue;
  /** Creates a new leftShooter. */
  public leftShooter() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0.00472, 0.000,0.0));
        leftShooterEncoder.setDistancePerPulse(0.001);
        m_controller.setTolerance(0.1);
  }

  @Override
  public void useOutput(double output, double setpoint) {
    leftShooter.set(output);
  }
  @Override
  public double getMeasurement() {
    AverageValue = 0;
    if(AverageValues.isEmpty()){
      AverageValues.add(leftShooterEncoder.getRate());
    }else if(AverageValues.size() < 5){
      AverageValues.add(leftShooterEncoder.getRate());
    }else{
      AverageValues.remove(0);
      AverageValues.add(leftShooterEncoder.getRate());
    }
    for(int i = 0; i<AverageValues.size();i = i+1){
      AverageValue = AverageValue + AverageValues.get(i);
    }
    AverageValue = AverageValue/AverageValues.size();
    SmartDashboard.putNumber("Left Shooter Encoder",leftShooterEncoder.getRate());
    return AverageValue;
  }

  public void setSpeed(DoubleSupplier speed){
    leftShooter.set(speed.getAsDouble());
    SmartDashboard.putNumber("Left Shooter Encoder",leftShooterEncoder.getRate());
  }
}
