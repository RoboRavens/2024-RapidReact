// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeDeploySubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private TalonFX _intakeDeployMotor = new TalonFX(RobotMap.INTAKE_DEPLOY_MOTOR);
  private double targetPosition = 0;

  public IntakeDeploySubsystem() {}

  public void goToPosition(double setpoint) {
    _intakeDeployMotor.setControl(new MotionMagicVoltage(setpoint));
    targetPosition = setpoint;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
