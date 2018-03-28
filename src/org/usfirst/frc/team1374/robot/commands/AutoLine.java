package org.usfirst.frc.team1374.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLine extends CommandGroup {
    public AutoLine() {
    	//AutonomousDriveCommand(speed, time, open arm for intake, intake motor, intake arm motor)
    	//the true and false for the arm is only to be used once true at the beginning of every auto command
    	//the rest are to turn on the motors for the intake arm and intake, and true  turn on false turns off, no speed control
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
    	
    	//addSequential(new AutonomousIntakeArmCommand(true, false));
    	addSequential(new AutonomousDriveCommand(0, 8000, 0));
    	addSequential(new AutonomousDriveCommand(0.5, 1500, 0));
    	//addSequential(new AutonomousIntakeCommand(1, 1000));
    }
}
