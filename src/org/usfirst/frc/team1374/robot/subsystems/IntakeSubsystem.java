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
	
	
	 public void openArmwheel(boolean close, boolean open) {
		 /*so the arm opens once and for the rest of the game stays open and probably starts open imo,
		 *so then this is basically for in the pit if the bot in on you can do it with operator, but im going to try to make it open in auto
		 *when in the pits use the manual overide for putting the solemoid back in place, or be alpha and use operator
		 */
		    	if (close) {
		    		openArm.set(Value.kForward);
		    	}
		    	
		    	else if (open) {
		    		openArm.set(Value.kReverse);
		    	}
		    	
		    }
		    
public void intakeArmfb(boolean forwards, boolean back, boolean not) {
	if (forwards) {
		intakeArm1.set(ControlMode.PercentOutput, 1);
		intakeArm2.set(ControlMode.PercentOutput, -1);
	}
	else if (back) {
		intakeArm1.set(ControlMode.PercentOutput, -1);
		intakeArm2.set(ControlMode.PercentOutput, 1);
	}
	else if (not){
		intakeArm1.set(ControlMode.PercentOutput, 0);
		intakeArm2.set(ControlMode.PercentOutput, 0);
	}
	else {
		intakeArm1.set(ControlMode.PercentOutput, 0);
		intakeArm2.set(ControlMode.PercentOutput, 0);
	}
}
	 
	 
public void intakefb(boolean intakef, boolean intakeb, boolean not) {
		//so the reason I have 3 things is because of in auto, when its false in auto it does nothing, but you can do that with 2, so yeet
	// if you were to do this regularly use 2
		if (intakef) {
			intake.set(ControlMode.PercentOutput, 1);
			intake2.set(ControlMode.PercentOutput, -1);
		}
		else if (intakeb) {
			intake.set(ControlMode.PercentOutput, -1);
			intake2.set(ControlMode.PercentOutput, 1);
		}
		else if (not){
			intake.set(ControlMode.PercentOutput, 0);
			intake2.set(ControlMode.PercentOutput, 0);
		}
		else {
			intake.set(ControlMode.PercentOutput, 0);
			intake2.set(ControlMode.PercentOutput, 0);
		}
		
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

