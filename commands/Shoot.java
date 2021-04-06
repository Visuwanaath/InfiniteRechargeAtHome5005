// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.leftShooter;
import frc.robot.subsystems.rightShooter;
public class Shoot extends CommandBase {
  /** Creates a new Shoot. */
  private leftShooter m_leftShooter;
  private rightShooter m_rightShooter;
  private DoubleSupplier m_speed;
  private BooleanSupplier m_cutoff;
  private BooleanSupplier m_limelight;
  private List<Double> targetDistances = new ArrayList<>();
  private List<Double> speedsAtTargetDistances = new ArrayList<>();
  private List<Double> distancesToTargetDistances = new ArrayList<>();
  private int tempValint;
  public Shoot(leftShooter leftShooter,rightShooter rightShooter,DoubleSupplier speed) {
    m_leftShooter = leftShooter;
    m_rightShooter = rightShooter;
    m_speed = speed;
    m_limelight =()-> false;
    m_cutoff = ()->true;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_rightShooter);
    addRequirements(m_leftShooter);
  }
  
  public Shoot(leftShooter leftShooter,rightShooter rightShooter,DoubleSupplier speed,BooleanSupplier cutoff) {
    m_leftShooter = leftShooter;
    m_rightShooter = rightShooter;
    m_speed = speed;
    m_cutoff = cutoff;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_rightShooter);
    addRequirements(m_leftShooter);
  }
  public Shoot(leftShooter leftShooter,rightShooter rightShooter) {
    m_leftShooter = leftShooter;
    m_rightShooter = rightShooter;
    m_speed = ()->0.5;
    m_cutoff = ()->true;
    m_limelight = ()->true;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_rightShooter);
    addRequirements(m_leftShooter);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
  public double GetDistance(double LimeHeight,double TargetHeight, double Angle,double LimelightAngle){
    Angle = Angle + LimelightAngle;
    Angle = Math.toRadians(Angle);
    double distance = (TargetHeight - LimeHeight) /(Math.tan(Angle));
    return distance;
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_limelight.getAsBoolean() == false){
      m_leftShooter.setSpeed(m_speed);
      double negativeSpeed = m_speed.getAsDouble() * -1;
      m_rightShooter.setSpeed(()->negativeSpeed);
      System.out.println("Speed" + m_speed.getAsDouble());  
    }else{
      if(NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0) == 1){
        double OffsetY = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
        double actual_Distance = GetDistance(18.5, 78, OffsetY, 35);
        SmartDashboard.putNumber("Distance", actual_Distance);
        targetDistances.clear();
        distancesToTargetDistances.clear();
        speedsAtTargetDistances.clear();
        targetDistances.add(170.0);
        speedsAtTargetDistances.add(-0.59);
        targetDistances.add(115.0);
        speedsAtTargetDistances.add(-0.65);
        //targetDistances.add(183.744);
        //speedsAtTargetDistances.add(-0.65);
        targetDistances.add(219.63);
        //was 0.58
        speedsAtTargetDistances.add(-0.56);
        for(int i=0;i<targetDistances.size();i++){
          distancesToTargetDistances.add(Math.abs(targetDistances.get(i) - actual_Distance));
        }
        double tempVal = distancesToTargetDistances.get(0);
        tempValint = 0;
    for(int i=0;i<distancesToTargetDistances.size();i++){
      if(tempVal>distancesToTargetDistances.get(i)){
        tempVal = distancesToTargetDistances.get(i);
        tempValint = i;
      }
    }
    SmartDashboard.putNumber("Distance To Target", distancesToTargetDistances.get(tempValint));
    SmartDashboard.putNumber("Target", targetDistances.get(tempValint));
    SmartDashboard.putNumber("Speeds", speedsAtTargetDistances.get(tempValint));
    m_leftShooter.setSpeed(()-> speedsAtTargetDistances.get(tempValint));
    m_rightShooter.setSpeed(()->speedsAtTargetDistances.get(tempValint)*-1);
  
      }

    }
    //0.575 zone 4
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(m_cutoff.getAsBoolean() == true){
      m_leftShooter.setSpeed(()->0);
      m_rightShooter.setSpeed(()->0);
    }
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
