// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.ctre.phoenix6.hardware.TalonFX;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new Conveyance1Subsystem. */
  private TalonFX _shooterTopspinMotor = new TalonFX(RobotMap.SHOOTER_TOPSPIN_MOTOR);
  private TalonFX _shooterBackspinMotor = new TalonFX(RobotMap.SHOOTER_BACKSPIN_MOTOR);
  public ShooterSubsystem() {}

  public void setShooterPower(double topspinPower, double backspinPower){
    _shooterTopspinMotor.set(topspinPower);
    _shooterBackspinMotor.set(backspinPower);
  }

  public Command getRunForwardCommand(){
    return this.startEnd(()-> setShooterPower(.5 , .5), ()-> stopShooter());
  }

  public Command getRunReverseCommand(){
    return this.startEnd(()-> setShooterPower(-0.5 , -0.5), ()-> stopShooter());
  }

  public Command getStopCommand(){
    return this.run(()-> stopShooter());
  }

  public void stopShooter(){
    _shooterTopspinMotor.set(0);
    _shooterBackspinMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Topspin RPM", _shooterTopspinMotor.getVelocity().getValueAsDouble());
    SmartDashboard.putNumber("Backspin RPM", _shooterBackspinMotor.getVelocity().getValueAsDouble());
  }
}
