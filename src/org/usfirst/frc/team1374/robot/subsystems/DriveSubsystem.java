package org.usfirst.frc.team1374.robot.subsystems;

import com.ctre.phoenix.MotorControl.CAN.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by FRC1334 on 6/2/2016.
 */
public class DriveSubsystem extends Subsystem {
    static TalonSRX left1 = new TalonSRX (0);
    static TalonSRX left2 = new TalonSRX (1);
    static TalonSRX right1 = new TalonSRX (2);
    static TalonSRX right2 = new TalonSRX (3);

    @Override
    protected void initDefaultCommand() {
    	
    }
    
    public static void tankDrive (double left, double right){
        left1.set(left);
        left2.set(left);
        right1.set(-right);
        right2.set(-right);
    }

        public static void arcadeDrive (double speed, double turn){
        tankDrive (speed-turn, speed+turn);
    }
}