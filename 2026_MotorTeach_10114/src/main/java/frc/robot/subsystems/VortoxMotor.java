package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;

public class VortoxMotor {
    private final SparkFlex motor = new SparkFlex(10, MotorType.kBrushless);//前面為馬達id，後面為馬達類型範例為無刷馬達

    public VortoxMotor() {//此爲建構式
        configure();//呼叫執行configure
    }

    public void configure() {//馬達安全機制以及設定
        var configure = new SparkFlexConfig();

        configure
                .idleMode(IdleMode.kCoast)//設定為coast模式
                .inverted(true)//是否反轉
                .smartCurrentLimit(80);//電流限制

        motor.configure(configure, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);//套用設定
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