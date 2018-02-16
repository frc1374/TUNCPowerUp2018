package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.Util.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousIntakeCommand extends Command {

	double Intake;
	double time;
	double start;
    public AutonomousIntakeCommand(double intake, double time) {
     	requires(Subsystems.INTAKE_SUBSYSTEM);
     	
     	intake = Intake;
     	start=System.currentTimeMillis();
     	this.time=time*1000;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Subsystems.INTAKE_SUBSYSTEM.intakefb(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Subsystems.INTAKE_SUBSYSTEM.intakefb(Intake);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() > start + time;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
