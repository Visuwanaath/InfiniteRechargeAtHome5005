// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.analog.adis16470.frc.ADIS16470_IMU;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class IMU extends SubsystemBase {
  /** Creates a new IMU. */
  public IMU() {}
  private final ADIS16470_IMU m_imu = new ADIS16470_IMU();
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public double getValue(){
    return m_imu.getAngle();
  }
  public double getXValue(){
    return m_imu.getXComplementaryAngle();
  }
  public double getYValue(){
    return m_imu.getYComplementaryAngle();
  }
  
}
