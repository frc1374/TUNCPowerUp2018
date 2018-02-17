package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.Util.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousIntakeArmCommand extends Command {
	
	boolean Open, Lower;
    public AutonomousIntakeArmCommand(boolean open, boolean lower) {
    	requires(Subsystems.INTAKE_SUBSYSTEM);
    	Lower = lower;
    	Open = open;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Subsystems.INTAKE_SUBSYSTEM.openArmWheelAuto(false, true);
    	Subsystems.INTAKE_SUBSYSTEM.lowerIntakeArm(false, true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Subsystems.INTAKE_SUBSYSTEM.openArmWheelAuto(Open, !Open);
    	Subsystems.INTAKE_SUBSYSTEM.lowerIntakeArm(Lower, !Lower);
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
