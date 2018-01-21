package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.Util.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class AutonomousDriveCommand extends Command {

	int Distance;
	double Start, End, Time, Speed;
	
    public AutonomousDriveCommand(double speed, double time, int distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Subsystems.DRIVE_SUBSYSTEM);
    	Distance = distance;
    	Time = time;
    	Speed = speed;
    }
    
    
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	// Subsystems.DRIVE_SUBSYSTEM.right1.set(ControlMode.Position, Distance);
    	// Subsystems.DRIVE_SUBSYSTEM.left1.set(ControlMode.Position, Distance);
    	
    	Start = System.currentTimeMillis();
    	End = System.currentTimeMillis();
    	
    	Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/* if (Math.abs(Subsystems.DRIVE_SUBSYSTEM.right1.getClosedLoopError(0)) < 10) {
    		End = System.currentTimeMillis();
    	}
    	
    	else {
    		Start = System.currentTimeMillis();
    	}
    	
    	// System.out.println(End - Start); */
    	Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(Speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(End - Start > Time) {
        	return true;
        }
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
