// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.ctre.phoenix6.hardware.TalonFX;

public class RearConveyanceSubsystem extends SubsystemBase {
  /** Creates a new Conveyance1Subsystem. */
  //private TalonFX _rearConveyanceMotor = new TalonFX(RobotMap.REAR_CONVEYANCE_MOTOR);
  public RearConveyanceSubsystem() {}

  public void setRearConveyancePower(double power){
    //_rearConveyanceMotor.set(power);
  }

  public Command getRunForwardCommand(){
    return this.startEnd(()-> setRearConveyancePower(.5), ()-> stopRearConveyance());
  }

  public Command getRunReverseCommand(){
    return this.startEnd(()-> setRearConveyancePower(-0.5), ()-> stopRearConveyance());
  }

  public Command getStopCommand(){
    return new InstantCommand(()-> stopRearConveyance());
  }

  public void stopRearConveyance(){
   // _rearConveyanceMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
