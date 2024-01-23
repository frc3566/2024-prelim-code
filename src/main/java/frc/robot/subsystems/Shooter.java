package frc.robot.subsystems;

import frc.robot.SwerveModule;
import frc.robot.Constants;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Shooter extends SubsystemBase {
    // motor components
    private CANSparkMax shooterLeftMotor; 
    private CANSparkMax shooterRightMotor; 

    public Shooter(){
        shooterLeftMotor = new CANSparkMax(9, MotorType.kBrushless);
        shooterRightMotor = new CANSparkMax(10, MotorType.kBrushless);

    }

    public void shoot(double power){
        shooterLeftMotor.set(-power);
        shooterRightMotor.set(-power);
    }

    public void stopMotor(){
        shooterLeftMotor.set(0);
        shooterRightMotor.set(0);
    }


    @Override
    public void periodic(){

    }

    @Override
    public void simulationPeriodic(){

    }

}
