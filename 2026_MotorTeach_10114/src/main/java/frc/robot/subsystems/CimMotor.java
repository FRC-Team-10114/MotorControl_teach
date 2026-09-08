package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;


public class CimMotor {
        private final SparkMax motor = new SparkMax(10, MotorType.kBrushless);

        public CimMotor() {
                configure();
        }

        public void configure() {
                var configure = new SparkMaxConfig();

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