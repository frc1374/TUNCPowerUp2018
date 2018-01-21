package org.usfirst.frc.team1374.robot;

import org.usfirst.frc.team1374.robot.Util.Xbox360Controller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private static final Xbox360Controller Controller = new Xbox360Controller(0);

    public static double getDriverSpeed() {
            return Controller.getRightTrigger() - Controller.getLeftTrigger();
    }
    public static double getSteer() {
        return Controller.getLeftXAxis();
    }
    
    public static boolean getClimber() {
    	return Controller.getButtonY();
    }
    
    public static boolean getHighGear() {
    	return Controller.getButtonA();
    }
    
    public static boolean getLowGear() {
    	return Controller.getButtonB();
    }
    
    public static boolean getOpen() {
    	return Controller.getButtonLB();
    }
    
    public static boolean getClose() {
    	return Controller.getButtonRB();
    }

    /**Usage:
     *
     * private static final Xbox360Controller JS_DRIVER = new Xbox360Controller(int port,double deadzone)
     *
     * Example:
     *
     * public static void getDriverSpeed()
     * {
     * return DRIVER.getRightTrigger() - DRIVER.getLeftTrigger()
     * }
     */
}

