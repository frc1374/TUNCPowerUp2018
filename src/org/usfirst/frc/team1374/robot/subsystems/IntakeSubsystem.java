package org.usfirst.frc.team1374.robot.subsystems;

import org.usfirst.frc.team1374.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public TalonSRX intake = new TalonSRX(RobotMap.intake);
	public TalonSRX intake2 = new TalonSRX(RobotMap.intake2);
	
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

