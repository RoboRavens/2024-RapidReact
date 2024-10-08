// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  //private TalonFX _intakeMotor = new TalonFX(RobotMap.INTAKE_MOTOR);
  public IntakeSubsystem() {}

  public void setIntakeSpeed(double speed){
    //_intakeMotor.set(speed);
  }

  public void stopIntake(){
    setIntakeSpeed(0);
  }

  public Command getIntakeCommand(){
    return this.startEnd(()-> setIntakeSpeed(.5), ()-> stopIntake());
  }

  public Command getStopIntakeCommand(){
    return new InstantCommand(()-> stopIntake());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
