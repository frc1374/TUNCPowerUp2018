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
    SendableChooser<String> chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        sub = new Subsystems();
        //oi = new OI();
        DriveCommands = new DriveCommand();
        IntakeCommands = new IntakeCommand();
        
        chooser = new SendableChooser<String>();
        chooser.addDefault("AutoLine", "AutoLine");
        chooser.addObject("LazyDown", "LazyDown");
        chooser.addObject("LazyUp", "LazyUp");
        chooser.addObject("CenterSwitch", "CenterSwitch");
        chooser.addObject("LeftSideSwitch", "LeftSideSwitch");
        chooser.addObject("RightSideSwitch", "RightSideSwitch");
        SmartDashboard.putData("Auto mode", chooser);
        
        CameraServer.getInstance().startAutomaticCapture(0);
        CameraServer.getInstance().startAutomaticCapture(1);
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
    	boolean switchSideR;
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if (gameData.length() > 0) {
        	if (gameData.charAt(0) == 'R') { switchSideR = true; }
        	else { switchSideR = false; }
        	String Selected = chooser.getSelected();
        	switch (Selected) {
	        	case "CenterSwitch":
	        		if (switchSideR) { autonomousCommand = new CenterRightSwitch(); }
	        		else { autonomousCommand = new CenterLeftSwitch(); }
	        		break;
	        	case "RightSideSwitch":
	        		if (switchSideR) { autonomousCommand = new RightSideSwitch(); }
	        		else { autonomousCommand = new AutoLine(); }
	        		break;
	        	case "LeftSideSwitch":
	        		if (switchSideR) { autonomousCommand = new AutoLine(); }
	        		else { autonomousCommand = new LeftSideSwitch(); }
	        		break;
	        	case "AutoLine":
	        		autonomousCommand = new AutoLine();
	        		break;
	        	case "LazyDown":
	        		autonomousCommand = new LazyDown();
	        		break;
	        	case "LazyUp":
	        		autonomousCommand = new LazyUp();
	        		break;
        	}
        }
    	else if (gameData == "") { gameData = "LLL"; }
    	else { gameData = DriverStation.getInstance().getGameSpecificMessage(); }
    	
        // autonomousCommand = (Command) chooser.getSelected();
    	//autonomousCommand = new AutoLine();
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
