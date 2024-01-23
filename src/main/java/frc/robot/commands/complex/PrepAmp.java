package frc.robot.commands.complex;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.arm.ShooterElevatorPosInstant;
import frc.robot.commands.arm.ShooterFlywheelSpeedInstant;
import frc.robot.commands.arm.ShooterPivotPosInstant;
import frc.robot.constants.ArmPositions;
import frc.robot.constants.ShooterSpeeds;

public class PrepAmp extends ParallelCommandGroup{
    public PrepAmp(){
        addCommands(
            new ShooterElevatorPosInstant(ArmPositions.AMP), 
            new ShooterFlywheelSpeedInstant(ShooterSpeeds.AMP),
            new ShooterPivotPosInstant(ArmPositions.AMP)
        );
    }
}