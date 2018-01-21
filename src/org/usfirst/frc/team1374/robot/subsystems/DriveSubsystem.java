package org.usfirst.frc.team1374.robot.subsystems;

import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;

public class DriveSubsystem extends Subsystem {
    public TalonSRX left1 = new TalonSRX(RobotMap.left1);
    public TalonSRX left2 = new TalonSRX(RobotMap.left2);
    public TalonSRX right1 = new TalonSRX(RobotMap.right1);
    public TalonSRX right2 = new TalonSRX(RobotMap.right2);
    public Compressor c = new Compressor(0);
    public static DoubleSolenoid s = new DoubleSolenoid(0, 1);
    public static DoubleSolenoid b = new DoubleSolenoid(2, 3);
    
    
    public void CompressorControl(){
    	c.setClosedLoopControl(true);    
    }
    
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
    
    public void tankDrive(double left, double right) {
        left1.set(ControlMode.PercentOutput, left);
        left2.set(ControlMode.PercentOutput, left);
        right1.set(ControlMode.PercentOutput, -right);
        right2.set(ControlMode.PercentOutput, -right);
    }

    public void arcadeDrive(double speed, double turn) {
        tankDrive (speed-turn, speed+turn);
    }
   
    public void shiftGear(boolean up, boolean down) {
  //msg to future chris up and down is in drive commands and becomes 
  //true/false when pressed and just change it from other things when changing
    	if(up){
    		s.set(Value.kForward);
    	}
    	
    	else if(down) {
    		s.set(Value.kReverse);
    	}
    	
    }
    
    public void Grabber(boolean open, boolean close) {

    	    	if(open){
    	    		b.set(Value.kForward);
    	    	}
    	    	
    	    	else if(close) {
    	    		b.set(Value.kReverse);
    	    	}
    	    	
    	    }
}