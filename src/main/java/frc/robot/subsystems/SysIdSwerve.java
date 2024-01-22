package frc.robot.subsystems;

import edu.wpi.first.units.Measure;
import edu.wpi.first.units.MutableMeasure;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.Voltage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;

public class SysIdSwerve extends Swerve {
    private final SysIdRoutine m_sysIdRoutine = new SysIdRoutine(
        // Empty config defaults to 1 volt/second ramp rate and 7 volt step voltage.
        new SysIdRoutine.Config(),
        new SysIdRoutine.Mechanism(
            // Tell SysId how to plumb the driving voltage to the motors.
            (Measure<Voltage> volts) -> {
                final MutableMeasure<Voltage> voltage = MutableMeasure.mutable(Units.Volts.of(0));
                mSwerveMods[0].getDriveMotor().setVoltage(voltage.in(Units.Volts));
                mSwerveMods[1].getDriveMotor().setVoltage(voltage.in(Units.Volts));
                mSwerveMods[2].getDriveMotor().setVoltage(voltage.in(Units.Volts));
                mSwerveMods[3].getDriveMotor().setVoltage(voltage.in(Units.Volts));
            },
            // Tell SysId how to record a frame of data for each motor on the mechanism being characterized.
            log -> { 
                // // Record a frame for the left motors.  Since these share an encoder, we consider the entire group to be one motor.
                // log.motor("drive-left") 
                //     .voltage(
                //         m_appliedVoltage.mut_replace(
                //             m_leftMotor.get() * RobotController.getBatteryVoltage(), Volts))
                //     .linearPosition(m_distance.mut_replace(m_leftEncoder.getDistance(), Meters))
                //     .linearVelocity(
                //         m_velocity.mut_replace(m_leftEncoder.getRate(), MetersPerSecond));
                
                // // Record a frame for the right motors.  Since these share an encoder, we consider the entire group to be one motor.
                // log.motor("drive-right")
                //     .voltage(
                //         m_appliedVoltage.mut_replace(
                //             m_rightMotor.get() * RobotController.getBatteryVoltage(), Volts))
                //     .linearPosition(m_distance.mut_replace(m_rightEncoder.getDistance(), Meters))
                //     .linearVelocity(
                //         m_velocity.mut_replace(m_rightEncoder.getRate(), MetersPerSecond));
            },
            
            // Tell SysId to make generated commands require this subsystem, suffix test state in
            // WPILog with this subsystem's name ("drive")
            this
        )
    );

    public Command sysIdQuasistatic(Direction kforward) {
        throw new UnsupportedOperationException("Unimplemented method 'sysIdQuasistatic'");
    }

    public Command sysIdDynamic(Direction kforward) {
        throw new UnsupportedOperationException("Unimplemented method 'sysIdDynamic'");
    }
}
