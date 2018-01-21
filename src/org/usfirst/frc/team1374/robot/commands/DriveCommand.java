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

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
    	Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(OI.getDriverSpeed(), OI.getSteer());
    	Subsystems.DRIVE_SUBSYSTEM.shiftGear(OI.getHighGear(), OI.getLowGear());
    	Subsystems.DRIVE_SUBSYSTEM.Grabber(OI.getOpen(), OI.getClose());
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
