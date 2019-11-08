package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.hatch.*;
import frc.robot.commands.other.*;
import frc.robot.commandgroups.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;

public class Robot extends TimedRobot {

    public Robot() {
        super(0.08);
    }

    public void robotInit() {

    }

    
    public void disabledInit() {

    }

    public void disabledPeriodic() {
       
    }

    public void autonomousInit() {

    }

    public void autonomousPeriodic() {
        
    }

    public void teleopInit() {
    
    }

    public void teleopPeriodic() {
       
    }
}
