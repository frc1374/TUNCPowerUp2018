package org.usfirst.frc.team1374.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	// drive
	public static final int left1      = 0;
    public static final int left2      = 1;
    public static final int right1     = 2;
    public static final int right2     = 3;
    
    public static final int compressor = 0;
    
    public static final int shift1     = 0;
    public static final int shift2     = 1;
    
    // intake
    public static final int intake     = 5;
    public static final int intake2    = 6;
    public static final int openArm1   = 2;
    public static final int openArm2   = 3;
    // climb
    public static final int climber    = 4;
    
}
