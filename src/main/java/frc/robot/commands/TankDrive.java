package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDrive extends Command {

    private double updatedSpeed = 0;
    private double updatedRotation = 0;
    private static final double maxChangeSpeed = 0.035d;
    private static final double maxChangeRotation = 0.2d;


    public TankDrive() {
        super("TankDrive");
        requires(Subsystems.driveBase);
    }

    @Override
    protected void execute() {
        double speed;
        double rotation;
        double speedDifference;
        double rotationDifference;

        if (UserInterface.driverController.getRightJoystickY() < -.1) {
            speed = -Math.pow(UserInterface.driverController.getRightJoystickY(), 2);
        } 
        else if (UserInterface.driverController.getRightJoystickY() > .1) {
            speed = Math.pow(UserInterface.driverController.getRightJoystickY(), 2);
        } 
        else {
            speed = 0.0d;
        }

        rotation = -Math.pow(UserInterface.driverController.getLeftJoystickX(), 3);

        updatedSpeed = UserInterface.driverController.getRightJoystickY();
        updatedRotation = UserInterface.driverController.getLeftJoystickX();
        speedDifference = speed - updatedSpeed;
        rotationDifference = rotation - updatedRotation;

        if (speedDifference > maxChangeSpeed){
            speed = speed + maxChangeSpeed;
        }
        else if (speedDifference < -maxChangeSpeed){
            speed = speed - maxChangeSpeed;
        }
        else {
            speed = updatedSpeed;
        }

        if (rotationDifference > maxChangeRotation){
            rotation = rotation + maxChangeRotation;
        }
        else if (rotationDifference < -maxChangeRotation){
            rotation = rotation - maxChangeRotation;
        }
        else {
            rotation = updatedRotation;
        }

        if (speed >= 0.5){
            speed = 0.5;
        }
        else if (speed <= -0.5){
            speed = -0.5;
        }
        
        if (rotation >= 5){
            rotation = 5;
        }
        else if (rotation <= -5){
            rotation = -5;
        }

        Subsystems.driveBase.cheesyDrive.curvatureDrive(speed, rotation, true);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
    }

    @Override
    protected void end() {
    }

}