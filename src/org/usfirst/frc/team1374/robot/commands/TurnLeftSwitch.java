package org.usfirst.frc.team1374.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TurnLeftSwitch extends CommandGroup {

    public TurnLeftSwitch() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new AutonomousDriveCommand(0.5, 2000, 0));
    	addSequential(new AutonomousDriveCommand(0.5, 420, -1));
    	addSequential(new AutonomousDriveCommand(0.5, 1500, 0));
    	addSequential(new AutonomousDriveCommand(0.5, 470, 1));
    	addSequential(new AutonomousDriveCommand(0.5, 2000, 0));
    }
}
