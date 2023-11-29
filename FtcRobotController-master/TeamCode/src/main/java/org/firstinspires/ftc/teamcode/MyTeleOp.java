package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "MyTeleOp", group = "FTC")
public class MyTeleOp extends OpMode {

    DcMotor frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;
    DcMotor armMotor;
    Servo clawServo;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        armMotor = hardwareMap.dcMotor.get("armMotor");
        clawServo = hardwareMap.servo.get("clawServo");
    }

    @Override
    public void loop() {
        double leftStickY = gamepad1.left_stick_y;
        double rightStickY = gamepad1.right_stick_y;

        double leftPowerRotate = leftStickY + rightStickY;
        double rightPowerRotate = leftStickY - rightStickY;

        if (leftStickY > 0 || rightStickY > 0) {
            frontLeftMotor.setPower(leftPowerRotate);
            frontRightMotor.setPower(rightPowerRotate);
            backLeftMotor.setPower(leftPowerRotate);
            backRightMotor.setPower(rightPowerRotate);
        }

        double leftTrigger = gamepad1.left_trigger*-1;
        double rightTrigger = gamepad1.right_trigger;

        double forwardsPower = rightTrigger;
        double backwardsPower = leftTrigger;

        if (leftTrigger < 0 && rightTrigger == 0 && leftStickY == 0 && rightStickY == 0) {
            frontLeftMotor.setPower(backwardsPower);
            frontRightMotor.setPower(backwardsPower);
            backLeftMotor.setPower(backwardsPower);
            backRightMotor.setPower(backwardsPower);
        }

        if (rightTrigger > 0 && leftTrigger == 0 && leftStickY == 0 && rightStickY == 0) {
            frontLeftMotor.setPower(forwardsPower);
            frontRightMotor.setPower(forwardsPower);
            backLeftMotor.setPower(forwardsPower);
            backRightMotor.setPower(forwardsPower);
        }

        double armPower = gamepad1.right_stick_x * 0.5;

        armMotor.setPower(armPower);

        if (gamepad1.x) {
            clawServo.setPosition(1.0);
        } else if (gamepad1.y) {
            clawServo.setPosition(0.0);
        }
        
    }

}