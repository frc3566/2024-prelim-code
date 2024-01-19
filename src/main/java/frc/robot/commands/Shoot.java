package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;

public class Shoot extends Command {
    private Shooter s_Shooter;
    private int leftTriggerID, rightTriggerID;
    public Shoot(Shooter s_Shooter, int leftTrigger, int rightTrigger) {
        addRequirements(s_Shooter);
        this.s_Shooter = s_Shooter;
        this.leftTriggerID = leftTrigger;
        this.rightTriggerID = rightTrigger;
    }
}
