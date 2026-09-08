package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;

public class VortoxMotor {
    private final SparkFlex motor = new SparkFlex(10, MotorType.kBrushless);

    public VortoxMotor() {
        configure();
    }

    public void configure() {
        var configure = new SparkFlexConfig();

        configure
                .idleMode(IdleMode.kCoast)
                .inverted(true)
                .smartCurrentLimit(80);

        motor.configure(configure, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void setSpeed() {
        this.motor.set(0);
    }

    public void setVoltage() {
        this.motor.setVoltage(0);
    }

    public void stop() {
        this.motor.stopMotor();
    }
}