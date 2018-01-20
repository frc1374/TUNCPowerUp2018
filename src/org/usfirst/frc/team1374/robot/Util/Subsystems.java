package org.usfirst.frc.team1374.robot.Util;

import org.usfirst.frc.team1374.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team1374.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by gabri on 2016-05-09.
 */
public class Subsystems {

    /**
     * Usage:
     *
     * public static ExampleSubsystem EXAMPLE_SUBSYSTEM;
     */
    public static DriveSubsystem DRIVE_SUBSYSTEM;
    public static ClimberSubsystem CLIMBER_SUBSYSTEM;

    public Subsystems()
    {
        /**
         * Usage:
         *
         * EXAMPLE_SUBSYSTEM = new ExampleSubsystem();
         */
     DRIVE_SUBSYSTEM = new DriveSubsystem();
     CLIMBER_SUBSYSTEM = new ClimberSubsystem();

    }


    public static void print(Object o)
    {
        System.out.println(o);
    }
}
