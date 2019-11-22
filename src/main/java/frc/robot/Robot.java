package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Subsystems;

public class Robot extends TimedRobot {

    public void robotInit() {
        Subsystems.compressor.start();
    }

    public void disabledInit() {
        Subsystems.arduino.sendCommand("0001111");
    }

    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
    }

    public void teleopInit() {
        if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
            Subsystems.arduino.sendCommand("0003331");
        } else {
            Subsystems.arduino.sendCommand("0002221");
        }
        Scheduler.getInstance().removeAll();
    }

    public void disabledPeriodic() {
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

}