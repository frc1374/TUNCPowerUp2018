package org.usfirst.frc.team1374.robot.subsystems;

import org.usfirst.frc.team1374.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public TalonSRX intake = new TalonSRX(RobotMap.intake);
	public TalonSRX intake2 = new TalonSRX(RobotMap.intake2);
	public TalonSRX intakeArm1 = new TalonSRX(RobotMap.intakeArm1);
	public TalonSRX intakeArm2 = new TalonSRX(RobotMap.intakeArm2);
	public static DoubleSolenoid openArm = new DoubleSolenoid(RobotMap.openArm1, RobotMap.openArm2);
	public static DoubleSolenoid lowerArm = new DoubleSolenoid(RobotMap.lowerArm1, RobotMap.lowerArm2);
	
	public void openArmWheel() {
		openArm.set(openArm.get() == Value.kReverse ? Value.kForward : Value.kReverse);
	}
	
	public void openArmWheelAuto(boolean open, boolean close) {
		
		if (open) {
			openArm.set(Value.kForward);
	    }
	    	
	    else if (close) {
	    	openArm.set(Value.kReverse);
	    } 	
	}
	
	public void lowerIntakeArm(boolean down, boolean up) {
		
		if (down) {
			lowerArm.set(Value.kForward);
		}
		
		else if (up) {
			openArm.set(Value.kReverse);
		}
	}
		    
	public void intakeArmFB(double axis) {
		intakeArm1.set(ControlMode.PercentOutput, +axis);
		intakeArm2.set(ControlMode.PercentOutput, -axis);
	}
	 
	 
	public void intakeFB(double axis) {
		axis = axis * 0.2;
		intake.set(ControlMode.PercentOutput, +axis);
		intake2.set(ControlMode.PercentOutput, -axis);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

