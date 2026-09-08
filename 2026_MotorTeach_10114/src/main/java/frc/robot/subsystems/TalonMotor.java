package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class TalonMotor {
    private final TalonFX motor = new TalonFX(10);//數字為馬達id

    public TalonMotor() {//此爲建構式
        configure();////呼叫執行configure
    }

    public void configure() {//馬達安全機制以及設定
        var configure = new TalonFXConfiguration();

        configure.CurrentLimits
                .withStatorCurrentLimitEnable(true)//開啓瞬時電流保護
                .withStatorCurrentLimit(80)//最大瞬時電流設定
                .withSupplyCurrentLimitEnable(true)//開啓子電流保護
                .withSupplyCurrentLimit(40);//最大子電流設定

        configure.MotorOutput.NeutralMode = NeutralModeValue.Coast;//設定為coast模式
        configure.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;//設定逆時鐘轉

        motor.getConfigurator().apply(configure);
    }

    public void setSpeed() {//馬達輸出速度 1 ~ -1
        this.motor.set(0);//更改裏面的數字更改輸出速度
    }

    public void setVoltage() {//馬達輸出電壓 12 ~ -12
        this.motor.setVoltage(0);//更改裏面的數字更改輸出電壓
    }

    public void stop() {//馬達停止方法
        this.motor.stopMotor();
    }
}
