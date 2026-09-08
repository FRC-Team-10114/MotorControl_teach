package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

public class TalonMotor {
    private final TalonFX motor = new TalonFX(10);

    public TalonMotor() {
        configure();
    }

    public void configure() {
        var motorConfig = new TalonFXConfiguration();

        motorConfig.CurrentLimits
                .withStatorCurrentLimitEnable(true)
                .withStatorCurrentLimit(40)
                .withSupplyCurrentLimitEnable(true)
                .withSupplyCurrentLimit(20);

        motor.getConfigurator().apply(motorConfig);
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
