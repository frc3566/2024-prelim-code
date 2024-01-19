package frc.robot;

import com.ctre.phoenix6.StatusCode;
// import com.ctre.phoenix6.controls.MotionMagicVoltage;
// import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
// import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest.SwerveControlRequestParameters;

public class SwerveVoltageRequest implements SwerveRequest {
    // private final MotionMagicVoltage m_motionMagicControl = new MotionMagicVoltage(0, false, 0, 0, false, false, false);
    // private final VoltageOut m_voltageOutControl = new VoltageOut(0.0);

    private double m_targetVoltage = 0.0;

    public StatusCode apply(SwerveControlRequestParameters parameters, SwerveModule... modulesToApply) {
        for (SwerveModule module : modulesToApply) 
        {
            // Command steer motor to zero
            // module.getSteerMotor().setControl(m_motionMagicControl);
            module.getAngleMotor().setVoltage(0);


            // Command drive motor to voltage
            // module.getDriveMotor().setControl(m_voltageOutControl.withOutput(m_targetVoltage));
            module.getDriveMotor().setVoltage(m_targetVoltage);

        }

        return StatusCode.OK;
    }

    /**
     * 
     * @param targetVoltage Voltage for all modules to target
     * @return 
     */
    public SwerveVoltageRequest withVoltage(double targetVoltage) {
        this.m_targetVoltage = targetVoltage;
        return this;
    }

    @Override
    public StatusCode apply(SwerveControlRequestParameters parameters,
            com.ctre.phoenix6.mechanisms.swerve.SwerveModule... modulesToApply) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }
}