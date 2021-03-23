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
public class rightShooter extends PIDSubsystem {
  private Encoder rightShooterEncoder = new Encoder(6,7);
  private Spark rightShooter = new Spark(Constants.shooterRight);
  ArrayList<Double> AverageValues = new ArrayList<Double>(5);
  double AverageValue;
  /** Creates a new rightShooter. */
  public rightShooter() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0.025, 0.05,0.0));
        rightShooterEncoder.setDistancePerPulse(0.001);
        m_controller.setTolerance(0.1);
  }

  @Override
  public void useOutput(double output, double setpoint) {
    rightShooter.set(output);
  } 
  @Override
  public double getMeasurement() {
    AverageValue = 0;
    if(AverageValues.isEmpty()){
      AverageValues.add(rightShooterEncoder.getRate());
    }else if(AverageValues.size() < 5){
      AverageValues.add(rightShooterEncoder.getRate());
    }else{
      AverageValues.remove(0);
      AverageValues.add(rightShooterEncoder.getRate());
    }
    for(int i = 0; i<AverageValues.size();i = i+1){
      AverageValue = AverageValue + AverageValues.get(i);
    }
    AverageValue = AverageValue/AverageValues.size();
    SmartDashboard.putNumber("Right Shooter Encoder",rightShooterEncoder.getRate());
    return AverageValue;
  }
  
  public void setSpeed(DoubleSupplier speed){
    rightShooter.set(speed.getAsDouble());
    SmartDashboard.putNumber("Right Shooter Encoder",rightShooterEncoder.getRate());
  }
}
