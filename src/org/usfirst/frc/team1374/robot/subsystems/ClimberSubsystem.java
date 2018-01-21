package org.usfirst.frc.team1374.robot.subsystems;

import org.usfirst.frc.team1374.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {

	public TalonSRX climber = new TalonSRX(RobotMap.climber);
	
	public void climbUp(boolean isClimbing) {
		
		if (isClimbing) {
			climber.set(ControlMode.PercentOutput, 1);
		}
		
		else {
			climber.set(ControlMode.PercentOutput, 0);
		}
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

