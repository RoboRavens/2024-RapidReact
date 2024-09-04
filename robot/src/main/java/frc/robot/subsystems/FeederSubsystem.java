// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class FeederSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private TalonFX _feederMotor = new TalonFX(RobotMap.FEEDER_MOTOR);
  public FeederSubsystem() {}

  public void setFeederSpeed(double speed){
    _feederMotor.set(speed);
  }

  public void stopFeeder(){
    setFeederSpeed(0);
  }

  public Command getRunForwardCommand(){
    return this.startEnd(()-> setFeederSpeed(.5), ()-> stopFeeder());
  }

  public Command getRunReverseCommand(){
    return this.startEnd(()-> setFeederSpeed(.5), ()-> stopFeeder());
  }

  public Command getStopFeederCommand(){
    return new InstantCommand(()-> stopFeeder());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
