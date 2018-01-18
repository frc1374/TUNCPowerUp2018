package org.usfirst.frc.team1374.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1374.robot.OI;
import org.usfirst.frc.team1374.robot.Util.Subsystems;

/**
 * Created by FRC1334 on 6/2/2016.
 */
public class DriveCommands extends Command {

    public DriveCommands(){
        requires(Subsystems.DRIVE_SUBSYSTEM);
    }

    @Override
    protected void initialize() {


    }

    @Override
    protected void execute() {
        Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(OI.getDriverSpeed(), OI.getSteer());
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
