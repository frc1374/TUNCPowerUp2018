package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.Util.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UltrasonicDistanceCommand extends Command {
	
	double CurrentDistance, TargetDistance, Start, End, Error, AllowedError;
	
    public UltrasonicDistanceCommand(double targetDistance, double allowedError) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Subsystems.DRIVE_SUBSYSTEM);
    	TargetDistance = targetDistance;
    	AllowedError = allowedError;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Subsystems.DRIVE_SUBSYSTEM.ultra.setAutomaticMode(true);
    	Start = System.currentTimeMillis();
    	End = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	CurrentDistance = Subsystems.DRIVE_SUBSYSTEM.findRange();
    	Error = CurrentDistance - TargetDistance;
    	if (Error < 60) {
    		Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(0.2, 0);
    		Start = System.currentTimeMillis();
    	}
    	else if (Error > AllowedError) {
    		Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(0.4, 0);
    		Start = System.currentTimeMillis();
    	}
    	else {
    		End = System.currentTimeMillis();
    		Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(0, 0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(End-Start > 500){
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
