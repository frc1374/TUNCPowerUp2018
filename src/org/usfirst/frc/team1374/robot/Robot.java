package org.usfirst.frc.team1374.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1374.robot.commands.*;
import org.usfirst.frc.team1374.robot.Util.Subsystems;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {


    public static OI oi;
    Command DriveCommands;
    Command IntakeCommands;
    Subsystems sub;
    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        sub = new Subsystems();
        //oi = new OI();
        DriveCommands = new DriveCommand();
        IntakeCommands = new IntakeCommand();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new AutoLine());
        chooser.addObject("Left DS", new StraightSwitch());
        chooser.addObject("Center DS", new TurnLeftSwitch());
        chooser.addObject("Right DS", new TurnRightSwitch());
        SmartDashboard.putData("Auto mode", chooser);
        CameraServer.getInstance().startAutomaticCapture();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	String gameData;
    	int station;
    	station = DriverStation.getInstance().getLocation();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
        if (gameData.length() > 0) {
        	if (gameData.charAt(0) == 'L') {
        		if (station == 1) {
        			autonomousCommand = new StraightSwitch();
        		}
        		else if (station == 2) {
        			autonomousCommand = new TurnLeftSwitch();
        		}
        		else {
        			autonomousCommand = new AutoLine();
        		}
        	}
        	else {
        		if (station == 3) {
        			autonomousCommand = new StraightSwitch();
        		}
        		else if (station == 2) {
        			autonomousCommand = new TurnRightSwitch();
        		}
        		else {
        			autonomousCommand = new AutoLine();
        		}
        	}
        }
        
        // autonomousCommand = (Command) chooser.getSelected();
    	autonomousCommand = new AutoLine();
    	//autonomousCommand = new AutonomousDriveCommand(0.5, 3500);
    	//autonomousCommand = new AutonomousDistanceCommand(1);
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        DriveCommands.start();
        IntakeCommands.start();
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
