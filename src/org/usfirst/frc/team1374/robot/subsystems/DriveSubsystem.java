package org.usfirst.frc.team1374.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
    public TalonSRX left1 = new TalonSRX(0);
    public TalonSRX left2 = new TalonSRX(1);
    public TalonSRX right1 = new TalonSRX(2);
    public TalonSRX right2 = new TalonSRX(3);

    
    public void setPIDDRIVE() {
    	left1.set(ControlMode.Position, 0);
    	right1.set(ControlMode.Position, 0);
    }
    
    public void setREGULARDRIVE(){
    	left1.set(ControlMode.PercentOutput, 0);
    	right1.set(ControlMode.PercentOutput, 0);
    }
    
    
    @Override
    protected void initDefaultCommand() {
    	left2.set(ControlMode.Follower, 0);
    	right2.set(ControlMode.Follower, 2);
    }
    
    public void tankDrive (double left, double right){
        left1.set(ControlMode.PercentOutput, left);
        left2.set(ControlMode.PercentOutput, left);
        right1.set(ControlMode.PercentOutput, -right);
        right2.set(ControlMode.PercentOutput, -right);
    }

        public void arcadeDrive (double speed, double turn){
        tankDrive (speed-turn, speed+turn);
    }
}