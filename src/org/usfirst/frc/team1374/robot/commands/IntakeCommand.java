package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.Util.Subsystems;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {

    public IntakeCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Subsystems.INTAKE_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Subsystems.INTAKE_SUBSYSTEM.intakeFB(OI.getIntake());
    	Subsystems.INTAKE_SUBSYSTEM.intakeArmFB(OI.getIntakeArm());
    	Subsystems.INTAKE_SUBSYSTEM.lowerIntakeArm(OI.getArmDown(), OI.getArmUp());
    	Subsystems.INTAKE_SUBSYSTEM.openArmWheel(OI.getFlipperOut(), OI.getFlipperIn());
    	//if(OI.getIntakeToggle()) Subsystems.INTAKE_SUBSYSTEM.openArmWheel();
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
