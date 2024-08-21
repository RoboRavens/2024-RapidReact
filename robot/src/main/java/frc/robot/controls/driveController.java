package frc.robot.controls;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.RobotMap;
import frc.robot.subsystems.FrontConveyanceSubsystem;
import frc.robot.Robot;

public class driveController {
    public static CommandXboxController _driveController;

    public static void enable() {
        _driveController = new CommandXboxController(RobotMap.DRIVE_CONTROLLER_PORT);

        _driveController.a().whileTrue(Robot._frontConveyanceSubsystem.getRunForwardCommand());
        
    }
}
