package frc.robot.commands;

import edu.wpi.first.math.controller.HolonomicDriveController;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Swerve;
import frc.robot.util.MathUtil;

public class DriveToPos extends Command {
    private Swerve s_Swerve;
    private Pose2d pose;
    private double x, y, rot;
    private PIDController kPXController = new PIDController(Constants.AutoConstants.kPXController, 0, 0);
    private PIDController kPYController = new PIDController(Constants.AutoConstants.kPYController, 0, 0);
    private ProfiledPIDController thetaController = new ProfiledPIDController(Constants.AutoConstants.kPThetaController, 0, 0, Constants.AutoConstants.kThetaControllerConstraints);
    // private HolonomicDriveController holodrive = new HolonomicDriveController();

    public DriveToPos(Swerve s_Swerve, Pose2d pose) {
        this.pose = pose;
        this.s_Swerve = s_Swerve;
        addRequirements(s_Swerve);
        kPXController.enableContinuousInput(-Math.PI, Math.PI);
        kPXController.setTolerance(1);
        
        kPYController.setTolerance(1);
        kPYController.enableContinuousInput(-Math.PI, Math.PI);

        thetaController.setTolerance(1);
        thetaController.enableContinuousInput(-Math.PI, Math.PI);
    }
    
    public void initialize() {
        x = pose.getX();
        y = pose.getY();
        rot = pose.getRotation().getDegrees();
        s_Swerve.resetOdometry(new Pose2d(new Translation2d(0, 0), new Rotation2d(0)));
    }

    public void execute() {
        double xVals = kPXController.calculate(s_Swerve.getPose().getX(), x);
        double yVals = kPYController.calculate(s_Swerve.getPose().getY(), y);
        double rotVals = thetaController.calculate(s_Swerve.getPose().getRotation().getDegrees(), rot);
        s_Swerve.drive(
            new Translation2d(Math.abs(MathUtil.clip(xVals, -0.4, 0.4)), Math.abs(MathUtil.clip(yVals, -0.4, 0.4))), 
            Math.abs(MathUtil.clip(rotVals, -0.4, 0.4)), 
            false, 
            true
        );
        // HolonomicDriveController.calculate(s_Swerve.getPose(), pose, )
    }
}
