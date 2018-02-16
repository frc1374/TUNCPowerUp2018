package org.usfirst.frc.team1374.robot.commands;

import org.usfirst.frc.team1374.robot.Util.Subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDistanceCommand extends Command {

	int Distance;
	double Start, End, targetPositionRotations;
	
    public AutonomousDistanceCommand(int distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Subsystems.DRIVE_SUBSYSTEM);
    	
    	Distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Start = System.currentTimeMillis();
    	End = System.currentTimeMillis();
    	
    	Subsystems.DRIVE_SUBSYSTEM.left1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		Subsystems.DRIVE_SUBSYSTEM.right1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		/* first choose the sensor */
		Subsystems.DRIVE_SUBSYSTEM.left1.setSensorPhase(true);
    	Subsystems.DRIVE_SUBSYSTEM.right1.setSensorPhase(false);
    	Subsystems.DRIVE_SUBSYSTEM.left1.setInverted(false);
		Subsystems.DRIVE_SUBSYSTEM.right1.setInverted(true);
		Subsystems.DRIVE_SUBSYSTEM.right2.setInverted(true);

    	  /* set the peak, nominal outputs, and deadband */
    	  Subsystems.DRIVE_SUBSYSTEM.left1.configNominalOutputForward(0, 50);
    	  Subsystems.DRIVE_SUBSYSTEM.left1.configNominalOutputReverse(0, 50);
    	  Subsystems.DRIVE_SUBSYSTEM.left1.configPeakOutputForward(1, 50);
    	  Subsystems.DRIVE_SUBSYSTEM.left1.configPeakOutputReverse(-1, 50);
    	  Subsystems.DRIVE_SUBSYSTEM.right1.configNominalOutputForward(0, 50);
    	  Subsystems.DRIVE_SUBSYSTEM.right1.configNominalOutputReverse(0, 50);
    	  Subsystems.DRIVE_SUBSYSTEM.right1.configPeakOutputForward(1, 50);
    	  Subsystems.DRIVE_SUBSYSTEM.right1.configPeakOutputReverse(-1, 50);
    	  Subsystems.DRIVE_SUBSYSTEM.left1.configAllowableClosedloopError(410, 0, 10);
    	  Subsystems.DRIVE_SUBSYSTEM.right1.configAllowableClosedloopError(410, 0, 10);
    	  Subsystems.DRIVE_SUBSYSTEM.left1.config_kF(0, 0.0, 10);
    	  Subsystems.DRIVE_SUBSYSTEM.left1.config_kP(0, 0.1, 10);
    	  Subsystems.DRIVE_SUBSYSTEM.left1.config_kI(0, 0.0, 10);
    	  Subsystems.DRIVE_SUBSYSTEM.left1.config_kD(0, 0.0, 10);
  		  Subsystems.DRIVE_SUBSYSTEM.right1.config_kF(0, 0.0, 10);
  		  Subsystems.DRIVE_SUBSYSTEM.right1.config_kP(0, 0.1, 10);
  		  Subsystems.DRIVE_SUBSYSTEM.right1.config_kI(0, 0.0, 10);
  		  Subsystems.DRIVE_SUBSYSTEM.right1.config_kD(0, 0.0, 10);
  		  Subsystems.DRIVE_SUBSYSTEM.left2.set(ControlMode.Follower, 0);
  		  Subsystems.DRIVE_SUBSYSTEM.right2.set(ControlMode.Follower, 2);
    	
  		int absolutePosition = Subsystems.DRIVE_SUBSYSTEM.left1.getSensorCollection().getPulseWidthPosition();
		int absolutePosition2 = Subsystems.DRIVE_SUBSYSTEM.right1.getSensorCollection().getPulseWidthPosition();
		/* mask out overflows, keep bottom 12 bits */
		absolutePosition &= 0xFFF;
		if (true)
			absolutePosition *= -1;
		if (false)
			absolutePosition *= -1;
		absolutePosition2 &= 0xFFF;
		if (true)
			absolutePosition2 *= -1;
		if (false)
			absolutePosition2 *= -1;
		
		Subsystems.DRIVE_SUBSYSTEM.left1.setSelectedSensorPosition(absolutePosition, 0, 10);
		Subsystems.DRIVE_SUBSYSTEM.right1.setSelectedSensorPosition(absolutePosition2, 0, 10);
  		  
    	//Subsystems.DRIVE_SUBSYSTEM.setPIDDRIVE();
    	//Subsystems.DRIVE_SUBSYSTEM.distanceDrive(Distance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Math.abs(Subsystems.DRIVE_SUBSYSTEM.right1.getClosedLoopError(0)) < 10 && Math.abs(Subsystems.DRIVE_SUBSYSTEM.left1.getClosedLoopError(0)) < 10) {
    		End = System.currentTimeMillis();
    		
    		Subsystems.DRIVE_SUBSYSTEM.left1.setSelectedSensorPosition(0, 0, 0);
    		Subsystems.DRIVE_SUBSYSTEM.right1.setSelectedSensorPosition(0, 0, 0);
			targetPositionRotations = Distance * 5.0 * 4096;
			Subsystems.DRIVE_SUBSYSTEM.left1.set(ControlMode.Position, targetPositionRotations);
			Subsystems.DRIVE_SUBSYSTEM.left2.set(ControlMode.Follower, 0);
			Subsystems.DRIVE_SUBSYSTEM.right1.set(ControlMode.Position, targetPositionRotations);
			Subsystems.DRIVE_SUBSYSTEM.right2.set(ControlMode.Follower, 2);
    	}
    	
    	else {
    		Start = System.currentTimeMillis();
    	}
    	
    	System.out.println(End - Start);
    	
    	System.out.println(Subsystems.DRIVE_SUBSYSTEM.left1.getClosedLoopError(0) + " left1");
        System.out.println(Subsystems.DRIVE_SUBSYSTEM.right1.getClosedLoopError(0) + " right1");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(End - Start > 500) {
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
