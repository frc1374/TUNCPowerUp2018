package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.Util.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;


public class AutonomousDriveCommand extends Command {

	double Start, End, Time, Speed;
	boolean Open, Intake, Intakearm;
	
    public AutonomousDriveCommand(double speed, double time, boolean open, boolean intake, boolean intakearm) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Subsystems.DRIVE_SUBSYSTEM);
    	Time = time;
    	Speed = speed;
    	Open = open;
    	Intake = intake;
    	Intakearm = intakearm;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	// Subsystems.DRIVE_SUBSYSTEM.right1.set(ControlMode.Position, Distance);
    	// Subsystems.DRIVE_SUBSYSTEM.left1.set(ControlMode.Position, Distance);
    	
    	Start = System.currentTimeMillis();
    	End = System.currentTimeMillis();
    	
    	Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(0, 0);
    	Subsystems.INTAKE_SUBSYSTEM.openArmwheel(false, false);
    	Subsystems.INTAKE_SUBSYSTEM.intakefb(false, false, true);
    	Subsystems.INTAKE_SUBSYSTEM.intakeArmfb(false, false, true);
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
    	Subsystems.INTAKE_SUBSYSTEM.openArmwheel(Open, !Open);
    	Subsystems.INTAKE_SUBSYSTEM.intakefb(Intake, false, !Intake);// the third one is do nothing, its go forward or nothing
    	Subsystems.INTAKE_SUBSYSTEM.intakeArmfb(Intakearm, false, !Intakearm);// the third one is do nothing, its go forward or nothing
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
