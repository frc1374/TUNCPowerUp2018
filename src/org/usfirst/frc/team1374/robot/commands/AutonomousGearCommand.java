package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.Util.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousGearCommand extends Command {
	boolean Gear;
    	 public AutonomousGearCommand(boolean gear) {
    		 requires(Subsystems.DRIVE_SUBSYSTEM);
    		 gear = Gear;
    	 }
    	     	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Subsystems.DRIVE_SUBSYSTEM.shiftGear(true, false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Subsystems.DRIVE_SUBSYSTEM.shiftGear(Gear, !Gear);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
