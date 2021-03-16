// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants;
import java.util.function.DoubleSupplier;
import java.lang.Math;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class omniWheelDriveTrain extends SubsystemBase {
  /** Creates a new omniWheelDriveTrain. */
  public omniWheelDriveTrain() {}
  private Spark north = new Spark(Constants.northOmniWheelPWM);
  private Spark east = new Spark(Constants.eastOmniWheelPWM);
  private Spark south = new Spark(Constants.southOmniWheelPWM);
  private Spark west = new Spark(Constants.westOmniWheelPWM);
  private Encoder northEncoder = new Encoder(0,1);
  private Encoder eastEncoder = new Encoder(6,7);
  private Encoder southEncoder = new Encoder(4,5);
  private Encoder westEncoder = new Encoder(2,3);
  @Override
  public void periodic() {
    SmartDashboard.putNumber("North Wheel", northEncoder.getDistance());
    SmartDashboard.putNumber("East Wheel", eastEncoder.getDistance());
    SmartDashboard.putNumber("South Wheel", southEncoder.getDistance());
    SmartDashboard.putNumber("West Wheel", westEncoder.getDistance());
  }
  public double getEncoderDistance(int encoderNumberSupplier){
    int encoderNumber = encoderNumberSupplier;
    if(encoderNumber == 1){
      return northEncoder.getDistance();
    }else if(encoderNumber == 2){
      return eastEncoder.getDistance();
    }else if(encoderNumber == 3){
      return southEncoder.getDistance();
    }else{
      return westEncoder.getDistance();
    }
  }
  public double getEncoderSpeed(int encoderNumberSupplier){
    int encoderNumber = encoderNumberSupplier;
    if(encoderNumber == 1){
      return northEncoder.getRate();
    }else if(encoderNumber == 2){
      return eastEncoder.getRate();
    }else if(encoderNumber == 3){
      return southEncoder.getRate();
    }else{
      return westEncoder.getRate();
    }
  }
  public void resetEncoders(){
    northEncoder.reset();
    eastEncoder.reset();
    southEncoder.reset();
    westEncoder.reset();
  }
  public void Go(DoubleSupplier xSupplier,DoubleSupplier ySupplier,DoubleSupplier rotSupplier){
    double X = xSupplier.getAsDouble();
    double Y = ySupplier.getAsDouble() * -1;
    double Rot = rotSupplier.getAsDouble();
    double rotAngle = Math.atan(Y/X);
    rotAngle = Math.toDegrees(rotAngle);
    if(X < 0 && Y<0){
      rotAngle =  -1*(180-rotAngle);
    }
    if(Y>0 && X<0){
      rotAngle = rotAngle + 180;
    }
    //System.out.println("Angle: " + rotAngle);
    rotAngle = rotAngle + 45;
    rotAngle = Math.toRadians(rotAngle);
    double hypotenuse = Math.sqrt(X*X + Y*Y);
    Y = Math.sin(rotAngle) * hypotenuse;
    X = Math.cos(rotAngle) * hypotenuse;
    //System.out.println("X: " + X);
    //System.out.println("Y: " + Y);
    if(Math.abs(Rot) > 0.5){
      if(Rot >0){
        Rot = 0.3;
      }else{
        Rot = -0.3;
      }
      north.set(Rot);
      east.set(Rot);
      south.set(Rot);
      west.set(Rot);
    }else{
      north.set(X* -1);
      east.set(Y * 1);
      south.set(X * 1);
      west.set(Y * -1);
    }
  }
  public void driveByAngle(DoubleSupplier angleSupplier,DoubleSupplier speedSupplier){
    double angle = angleSupplier.getAsDouble();
    double speed = speedSupplier.getAsDouble();
    double rotAngle = angle + 45;
    rotAngle = Math.toRadians(rotAngle);
    double Y = Math.sin(rotAngle) * speed;
    double X = Math.cos(rotAngle) * speed;
    north.set(X*-1);
    east.set(Y);
    south.set(X);
    west.set(Y*-1);
  }
  public void rotate(DoubleSupplier speed){
    double Rot = speed.getAsDouble();
      north.set(Rot);
      east.set(Rot);
      south.set(Rot);
      west.set(Rot);
  }
  public void setSpeedsRaw(DoubleSupplier northSupplier,DoubleSupplier eastSupplier, DoubleSupplier southSupplier, DoubleSupplier westSupplier){
    north.set(northSupplier.getAsDouble());
    east.set(eastSupplier.getAsDouble());
    south.set(southSupplier.getAsDouble());
    west.set(westSupplier.getAsDouble());
  }
}