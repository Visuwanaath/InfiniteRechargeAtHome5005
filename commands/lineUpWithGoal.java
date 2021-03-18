// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.omniWheelDriveTrain;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class lineUpWithGoal extends CommandBase {
  omniWheelDriveTrain m_OmniWheelDriveTrain;
  double TargetDetected;
  boolean EndNow;
  double RightMotorSpeed;
  double LeftMotorSpeed;
  double STEER_K;
  double DRIVE_K;
  double DESIRED_TARGET_AREA;
  double MAX_DRIVE;
  double steer_cmd;
  double drive_cmd;
  double Desired_distance;
  double actual_Distance;
  boolean m_DriveToDistance;
  //IMPORT LINE BELOW FOR ACCESSSING STUFF FROM LIMELIGHT
  //NetworkTableInstance.getDefault().getTable("limelight").getEntry("<variablename>").getDouble(0);

  /** Creates a new lineUpWithGoal. */
  public lineUpWithGoal(omniWheelDriveTrain subsystem,boolean driveToDistance) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_OmniWheelDriveTrain = subsystem;
    m_DriveToDistance = driveToDistance;
    addRequirements(m_OmniWheelDriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    STEER_K = 0.0725;                    // how hard to turn toward the target
    DRIVE_K = 0.07;                    // how hard to drive fwd toward the target
    MAX_DRIVE = 0.5;                   // Simple speed limit so we don't drive too fast
    Desired_distance = 84;
    EndNow = false;
    TargetDetected = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    SmartDashboard.putNumber("Desired Distance", Desired_distance);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(TargetDetected == 1){
      double OffsetX = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
      double OffsetY = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
      double MIN_DRIVE = 0.25;
    if(m_DriveToDistance == false){
      DRIVE_K = 0;
    }
    actual_Distance = GetDistance(18.2, 89, OffsetY, 27);
    SmartDashboard.putNumber("Actual Distance", actual_Distance);
    if(OffsetX != 0){
      steer_cmd = OffsetX * STEER_K;
      drive_cmd = (actual_Distance- Desired_distance) * DRIVE_K;
    if (drive_cmd > MAX_DRIVE)
    {
      drive_cmd = MAX_DRIVE;
    }
    m_OmniWheelDriveTrain.Go(()->drive_cmd,()->steer_cmd, ()->0);
    }else{
      EndNow = true;
      m_OmniWheelDriveTrain.driveByAngle(()->0, ()->0);
    }
  }else if(TargetDetected == 0){
    m_OmniWheelDriveTrain.driveByAngle(()->0, ()->0);
  }
}
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }
  public double GetDistance(double LimeHeight,double TargetHeight, double Angle,double LimelightAngle){
    Angle = Angle + LimelightAngle;
    Angle = Math.toRadians(Angle);
    double distance = (TargetHeight - LimeHeight) /(Math.tan(Angle));
    return distance;
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}