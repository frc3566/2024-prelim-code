package frc.robot.commands;

import frc.robot.subsystems.*;

import java.util.function.DoubleSupplier;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import edu.wpi.first.wpilibj2.command.Command;

public class Shoot extends Command {
    private Shooter s_Shooter;
    private double targetVelocity = 0.5;

    public Shoot(Shooter s_Shooter) {
    // public Shoot(Shooter s_Shooter, DoubleSupplier targetVelocity) {
        addRequirements(s_Shooter);
        this.s_Shooter = s_Shooter;
        SparkPIDController pid = s_Shooter.PIDController;
        pid.setReference(targetVelocity, ControlType.kDutyCycle);

        // this.targetVelocity = targetVelocity;
    }
    
    public void execute() {
        s_Shooter.setPower(targetVelocity);
    }
}
