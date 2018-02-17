package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.Util.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
/* MATH******
 * LOWGEAR RATIO 154:66
 * HIGHGEAR RATIO 138:82
 * 6in diamiter wheels, so the we have  18.84"  circumference
 * so  encoder tick*tire rotation= distance travaled
 * LOWGEAR MATH********
 * for every 154 rotations of the encoder is 9856 ticks
 * thats 54 rotations of the wheel, which is 1243.44in
 * that means that for every encoder tick, the bot will travel 0.12616071428in
 * HIGHGEAR MATH*******
 * for every 138 rotations of the encoder is 8832 ticks
 * thats 82 rotations of the wheel, which is 1544.88in
 * that means that for every encoder tick, the bot will travel 0.17491847826in
 */

public class AutonomousDriveCommand extends Command {

	double Start, End, Time, Speed, Turn;

    public AutonomousDriveCommand(double speed, double time, double turn) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Subsystems.DRIVE_SUBSYSTEM);
    	Time = time;
    	Speed = speed;
    	Turn = turn;
    }


    // Called just before this Command runs the first time
    protected void initialize() {
    	// Subsystems.DRIVE_SUBSYSTEM.right1.set(ControlMode.Position, Distance);
    	// Subsystems.DRIVE_SUBSYSTEM.left1.set(ControlMode.Position, Distance);

    	Start = System.currentTimeMillis();
    	End = System.currentTimeMillis();

    	Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(0, 0);

    	/*
    	Subsystems.INTAKE_SUBSYSTEM.openArmwheel(false, false);
    	Subsystems.INTAKE_SUBSYSTEM.intakefb(false, false, true);
    	Subsystems.INTAKE_SUBSYSTEM.intakeArmfb(false, false, true);
    	*/
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
    	Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(Speed, Turn);
    	End = System.currentTimeMillis();
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
