package org.usfirst.frc.team1374.robot.subsystems;

import org.usfirst.frc.team1374.robot.RobotMap;
import org.usfirst.frc.team1374.robot.Util.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Ultrasonic;

public class DriveSubsystem extends Subsystem {
	public static int speedconst = 10;
    public TalonSRX left1 = new TalonSRX(RobotMap.left1);
    public TalonSRX left2 = new TalonSRX(RobotMap.left2);
    public TalonSRX right1 = new TalonSRX(RobotMap.right1);
    public TalonSRX right2 = new TalonSRX(RobotMap.right2);
    public Compressor c = new Compressor(RobotMap.compressor);
    public static DoubleSolenoid shift = new DoubleSolenoid(RobotMap.shift1, RobotMap.shift2);
    public Ultrasonic ultra = new Ultrasonic(0, 1);
    
    public void CompressorControl(){
    	c.setClosedLoopControl(true);    
    }
    
    public void setPIDDRIVE() {
    	left1.set(ControlMode.Position, 0);
    	right1.set(ControlMode.Position, 0);
    	left2.set(ControlMode.Follower, 0);
    	right2.set(ControlMode.Follower, 2);
    }
    
    public void setREGULARDRIVE(){
    	left1.set(ControlMode.Velocity, 0);
    	right1.set(ControlMode.Velocity, 0);
    	left2.set(ControlMode.Follower, 0);
    	right2.set(ControlMode.Follower, 2);
    }
    
    public void distanceDrive(int distance) {
    	left1.set(ControlMode.Position, distance * 4096);
    	left2.set(ControlMode.Follower, 0);
    	right1.set(ControlMode.Position, distance * 4096);
    	right2.set(ControlMode.Follower, 2);
    }
    
    @Override
    protected void initDefaultCommand() {
    	left2.set(ControlMode.Follower, 0);
    	right2.set(ControlMode.Follower, 2);
    }
    
    public void tankDrive(double left, double right) {
        left1.set(ControlMode.PercentOutput, -left);
        left2.set(ControlMode.PercentOutput, -left);
        right1.set(ControlMode.PercentOutput, right);
        right2.set(ControlMode.PercentOutput, right);
    }

    public void distanceTankDrive(double left, double right) {
    	left1.set(ControlMode.Position, 500);
		left2.set(ControlMode.Follower, 0);
		right1.set(ControlMode.Position, 500);
		right2.set(ControlMode.Follower, 2);
    }
    
    public void arcadeDrive(double speed, double turn) {
        tankDrive (speed-turn, speed+turn);
    }
    
    public String distanceArcadeDrive(double speed, double turn) {
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
    
    public double findRange() {
    	double range = ultra.getRangeInches();
		return range;
    }
    
}