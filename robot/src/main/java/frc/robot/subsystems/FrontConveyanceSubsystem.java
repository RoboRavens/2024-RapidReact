// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.ctre.phoenix6.hardware.TalonFX;

public class FrontConveyanceSubsystem extends SubsystemBase {
  /** Creates a new Conveyance1Subsystem. */
  private TalonFX _frontConveyanceMotor = new TalonFX(RobotMap.FRONT_CONVEYANCE_MOTOR);
  public FrontConveyanceSubsystem() {}

  public void setFrontConveyancePower(double power){
    _frontConveyanceMotor.set(power);
  }

  public Command getRunForwardCommand(){
    return this.startEnd(()-> setFrontConveyancePower(.5), ()-> stopFrontConveyance());
  }

  public Command getRunReverseCommand(){
    return this.startEnd(()-> setFrontConveyancePower(-0.5), ()-> stopFrontConveyance());
  }

  public Command getStopCommand(){
    return this.run(()-> stopFrontConveyance());
  }

  public void stopFrontConveyance(){
    _frontConveyanceMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
