// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final omniWheelDriveTrain m_omniWheelDriveTrain = new omniWheelDriveTrain();
  private final Shooter m_shooter = new Shooter();
  private final Feeder m_feeder = new Feeder();
  private final Loader m_loader = new Loader();
  private final IMU m_IMU = new IMU();
  private Joystick controller1 = new Joystick(0);
  private Joystick controller2 = new Joystick(1);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_omniWheelDriveTrain.setDefaultCommand(new defaultDrive(m_omniWheelDriveTrain,()->controller2.getRawAxis(0),()->controller2.getRawAxis(1),()->controller2.getRawAxis(2)));
    m_IMU.setDefaultCommand(new readIMU(m_IMU));
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(controller2,1).whileHeld(new Shoot(m_shooter,()->1.0));
    new JoystickButton(controller2,2).whileHeld(new Feed(m_feeder,()->0.3));
    new JoystickButton(controller2,3).whileHeld(new Load(m_loader,()->1));
    new JoystickButton(controller2,4).whenReleased(new LoopyCourse(m_omniWheelDriveTrain,m_IMU));
    new JoystickButton(controller2,5).whileHeld(new rotateToAngle(m_IMU, m_omniWheelDriveTrain, ()->45));
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
