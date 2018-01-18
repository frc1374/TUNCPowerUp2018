package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.Util.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDriveCommand extends Command {

	int Distance;
	double Start, End;
	
    public AutonomousDriveCommand(int distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	Distance = distance;
    	requires(Subsystems.DRIVE_SUBSYSTEM);
    }
    
    
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Subsystems.DRIVE_SUBSYSTEM.right1.set(ControlMode.Position, Distance);
    	Subsystems.DRIVE_SUBSYSTEM.left1.set(ControlMode.Position, Distance);
    	
    	Start = System.currentTimeMillis();
    	End = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Math.abs(Subsystems.DRIVE_SUBSYSTEM.right1.getClosedLoopError(0)) < 10) {
    		
    		End = System.currentTimeMillis();
    		
    	}
    	
    	else {
    		Start = System.currentTimeMillis();
    	}
    	
    	// System.out.println(End - Start);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(End - Start > 500){
        	return true;
        }
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
