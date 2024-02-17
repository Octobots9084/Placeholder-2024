package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.constants.ShooterSpeeds;
import frc.robot.subsystems.ShooterFlywheel;

public class ShooterFlywheelSpeedInstant extends InstantCommand {

    ShooterSpeeds shooterSpeeds;
    ShooterFlywheel flywheel;

    public ShooterFlywheelSpeedInstant(ShooterSpeeds shooterSpeeds) {
        this.shooterSpeeds = shooterSpeeds;
        flywheel = ShooterFlywheel.getInstance();
        super.addRequirements(flywheel);

        initialize();
    }

    @Override
    public void initialize() {
        flywheel.setFlywheelSpeed(shooterSpeeds);
    }
}