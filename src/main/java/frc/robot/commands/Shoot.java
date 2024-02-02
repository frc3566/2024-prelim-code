package frc.robot.commands;

import frc.robot.subsystems.*;

import java.util.function.DoubleSupplier;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import edu.wpi.first.wpilibj2.command.Command;

public class Shoot extends Command {
    private Shooter s_Shooter;
    private double targetVelocity;
    private SparkPIDController pid;

    public Shoot(Shooter s_Shooter, double targetVelocity) {
    // public Shoot(Shooter s_Shooter, DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier targetVelocity) {
        addRequirements(s_Shooter);
        this.s_Shooter = s_Shooter;
        pid = s_Shooter.PIDController;
        // pid.setReference(-targetVelocity, ControlType.kVelocity);
    }
    
    public void execute() {
        pid.setReference(-targetVelocity, ControlType.kDutyCycle);
        s_Shooter.setPower(-targetVelocity);
    }
}
