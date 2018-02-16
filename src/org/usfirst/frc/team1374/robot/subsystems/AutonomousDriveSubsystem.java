package org.usfirst.frc.team1374.robot.subsystems;

import org.usfirst.frc.team1374.robot.RobotMap;
import org.usfirst.frc.team1374.robot.Util.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class AutonomousDriveSubsystem extends Subsystem {
	
    public TalonSRX left1 = new TalonSRX(RobotMap.left1);
    public TalonSRX left2 = new TalonSRX(RobotMap.left2);
    public TalonSRX right1 = new TalonSRX(RobotMap.right1);
    public TalonSRX right2 = new TalonSRX(RobotMap.right2);
    public Compressor c = new Compressor(RobotMap.compressor);
    public static DoubleSolenoid shift = new DoubleSolenoid(RobotMap.shift1, RobotMap.shift2);
    // public static int speedconst = 10;
    // int closedLoopErrL = left1.getClosedLoopError(0);
    // int closedLoopErrR = right1.getClosedLoopError(0);
    
    public void CompressorControl(){
    	c.setClosedLoopControl(true);    
    }
    
    /* public void setPIDDRIVE() {
    	left1.set(ControlMode.Position, 0);
    	left2.set(ControlMode.Follower, 0);
    	right1.set(ControlMode.Position, 0);
    	right2.set(ControlMode.Follower, 2);
    }
    
    public void setREGULARDRIVE(){
    	left1.set(ControlMode.PercentOutput, 0);
    	left2.set(ControlMode.Follower, 0);
    	right1.set(ControlMode.PercentOutput, 0);
    	right2.set(ControlMode.Follower, 2);
    } */
    
    public void distanceDrive(int distance) {
    
    	left1.set(ControlMode.Position, distance * 4096);
    	left2.set(ControlMode.Follower, 0);
    	right1.set(ControlMode.Position, -distance * 4096);
    	right2.set(ControlMode.Follower, 2);
    }
    
    @Override
    protected void initDefaultCommand() {
    	left2.set(ControlMode.Follower, 0);
    	right2.set(ControlMode.Follower, 2);
    }
    
    public void tankDrive(double left, double right) {
        left1.set(ControlMode.Velocity, left);
        left2.set(ControlMode.Follower, 0);
        right1.set(ControlMode.Velocity, -right);
        right2.set(ControlMode.Follower, 2);
    }
    
    public String arcadeDrive(double speed, double turn) {
    	tankDrive ((speed-turn) * 4096 * 500.0 / 600, (speed+turn) * 4096 * 500.0 / 600);
    	return (speed-turn) * 4096 * 500.0 / 600 + "";
    }
   
    public void shiftGear(boolean up, boolean down) {
  //msg to future chris up and down is in drive commands and becomes 
  //true/false when pressed and just change it from other things when changing
    	if (up) {
    		shift.set(Value.kForward);
    	}
    	
    	else if (down) {
    		shift.set(Value.kReverse);
    	}
    	
    }
     
}