package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.Util.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousIntakeCommand extends Command {

	double Intake, Time, Start, End;
	boolean Lower;
	
    public AutonomousIntakeCommand(double intake, double time, boolean lower) {
     	requires(Subsystems.INTAKE_SUBSYSTEM);
     	Intake = intake;
     	Time = time;
     	Lower = lower;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Subsystems.INTAKE_SUBSYSTEM.intakeFB(0);
    	Subsystems.INTAKE_SUBSYSTEM.lowerIntakeArm(true, false);

    	Start = System.currentTimeMillis();
    	End = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Subsystems.INTAKE_SUBSYSTEM.intakeFB(Intake);
    	Subsystems.INTAKE_SUBSYSTEM.lowerIntakeArm(!Lower, Lower);
    	End = System.currentTimeMillis();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (End - Start > Time) {
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
