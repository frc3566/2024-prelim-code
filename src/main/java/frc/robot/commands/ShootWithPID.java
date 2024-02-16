package frc.robot.commands;

import frc.robot.subsystems.*;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;

public class ShootWithPID extends Command {
    private ShooterPID s_Shooter;
    private DoubleSupplier targetVelocity;

    public ShootWithPID(ShooterPID s_Shooter, DoubleSupplier targetVelocity) {
        addRequirements(s_Shooter);
        this.s_Shooter = s_Shooter;
        this.targetVelocity = targetVelocity;
    }
    
    public void execute() {
        s_Shooter.setPower(targetVelocity.getAsDouble());
    }
}
