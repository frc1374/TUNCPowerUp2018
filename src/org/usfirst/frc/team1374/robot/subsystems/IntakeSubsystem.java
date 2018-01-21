package org.usfirst.frc.team1374.robot.subsystems;

import org.usfirst.frc.team1374.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	
	public static DoubleSolenoid grab = new DoubleSolenoid(RobotMap.grab1, RobotMap.grab2);
	public static DoubleSolenoid raise = new DoubleSolenoid(RobotMap.raise1, RobotMap.raise2);

	public void grabber(boolean open, boolean close) {

    	if (open) {
    		grab.set(Value.kForward);
    	}
    	
    	else if (close) {
    		grab.set(Value.kReverse);
    	}
    	
    }
	
	public void raiseIntake(boolean up, boolean down) {

    	if (up) {
    		raise.set(Value.kForward);
    	}
    	
    	else if (down) {
    		raise.set(Value.kReverse);
    	}
    	
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

