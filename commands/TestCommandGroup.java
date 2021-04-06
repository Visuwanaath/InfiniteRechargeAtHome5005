// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.omniWheelDriveTrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.leftShooter;
import frc.robot.subsystems.rightShooter;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TestCommandGroup extends SequentialCommandGroup {
  /** Creates a new TestCommandGroup. */
  public TestCommandGroup(omniWheelDriveTrain subsystem,leftShooter m_leftShooter,rightShooter m_rightShooter,Feeder m_feeder) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //170,0.59
      //110,125 sidewys,0.62
      new rotateToAngle(subsystem,()->0)
      //new Shoot(m_leftShooter,m_rightShooter,()->-0.62,()->false).withTimeout(3),
      //new Feed(m_feeder,()->0.3).withTimeout(0.2),
      //new Feed(m_feeder,()->0.0).withTimeout(1.25),
      //new Feed(m_feeder,()->0.3).withTimeout(0.2),
      //new Feed(m_feeder,()->0.0).withTimeout(1.25),
      //new Feed(m_feeder,()->0.3).withTimeout(0.3),
      //new Feed(m_feeder,()->0.0).withTimeout(0.2),
      //new Shoot(m_leftShooter,m_rightShooter,()->-0).withTimeout(0.2)
      //new defaultDrive(subsystem, ()->0.7,()->0,()->0).withTimeout(0.8)
    );
  }
}
