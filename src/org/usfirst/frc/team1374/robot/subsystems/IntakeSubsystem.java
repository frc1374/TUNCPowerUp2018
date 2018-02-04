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
	public static DoubleSolenoid openArm = new DoubleSolenoid(RobotMap.openArm1, RobotMap.openArm2);
	
	
	 public void openArmwheel(boolean close, boolean open) {
		 /*so the arm opens once and for the rest of the game stays open and probably starts open imo,
		 *so then this is basicly for in the pit if the bot in on you can do it with operator, but im going to try to make it open in auto
		 */
		    	if (close) {
		    		openArm.set(Value.kForward);
		    	}
		    	
		    	else if (open) {
		    		openArm.set(Value.kReverse);
		    	}
		    	
		    }
		    
	 
public void intakefb(boolean intakef, boolean intakeb) {
		
		if (intakef) {
			intake.set(ControlMode.PercentOutput, 1);
			intake2.set(ControlMode.PercentOutput, 1);
		}
		if (intakeb) {
			intake.set(ControlMode.PercentOutput, -1);
			intake2.set(ControlMode.PercentOutput, -1);
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

