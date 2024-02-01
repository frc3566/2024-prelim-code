package frc.robot.commands;

import frc.robot.subsystems.*;

import java.util.function.DoubleSupplier;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import edu.wpi.first.wpilibj2.command.Command;

public class Shoot extends Command {
    private Shooter s_Shooter;
    private DoubleSupplier left, right, targetVelocity;

    public Shoot(Shooter s_Shooter) {
    // public Shoot(Shooter s_Shooter, DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier targetVelocity) {
        addRequirements(s_Shooter);
        this.s_Shooter = s_Shooter;
        s_Shooter.setReference(0.5)

        // this.targetVelocity = targetVelocity;
    }
    
    public void execute() {
        // SparkPIDController pid = s_Shooter.PIDController;
        // pid.setReference(targetVelocity, ControlType.kVelocity);
        s_Shooter.setPower(left.getAsDouble() - right.getAsDouble());
    }
}
