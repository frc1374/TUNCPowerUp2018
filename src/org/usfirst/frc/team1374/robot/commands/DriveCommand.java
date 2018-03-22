package org.usfirst.frc.team1374.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.Util.Subsystems;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand(){
        requires(Subsystems.DRIVE_SUBSYSTEM);
    }
    
    //StringBuilder _sb = new StringBuilder();
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(OI.getDriverSpeed(), OI.getSteer());
    	Subsystems.DRIVE_SUBSYSTEM.shiftGear(OI.getHighGear(), OI.getLowGear());
    	/*if (OI.distanceDrive()) {
    		Subsystems.DRIVE_SUBSYSTEM.distanceDrive(5000);
    	}*/
    	
    	/* _sb.append("\tout:");
   	 	_sb.append(Subsystems.DRIVE_SUBSYSTEM.left1.getMotorOutputPercent());
   	 	_sb.append("\tspd:");
   	 	_sb.append(Subsystems.DRIVE_SUBSYSTEM.left1.getSelectedSensorVelocity(0));
   	 	_sb.append("\ttrg:");
   	 	_sb.append(Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(OI.getDriverSpeed(), OI.getSteer()));
   	 	_sb.append("\terr:");
   	 	_sb.append(Subsystems.DRIVE_SUBSYSTEM.left1.getClosedLoopError(0));
   	 	_sb.append("\tposL1:" + Subsystems.DRIVE_SUBSYSTEM.left1.getSelectedSensorPosition(0));
   	 	_sb.append("\tposL2:" + Subsystems.DRIVE_SUBSYSTEM.left2.getSelectedSensorPosition(0));

   	 	_sb.append("\tposR1:" + Subsystems.DRIVE_SUBSYSTEM.right1.getSelectedSensorPosition(0));

   	 	_sb.append("\tposR2:" + Subsystems.DRIVE_SUBSYSTEM.right2.getSelectedSensorPosition(0));

   	 
   	 	System.out.println(_sb.toString());
   	 	_sb.setLength(0); */
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
