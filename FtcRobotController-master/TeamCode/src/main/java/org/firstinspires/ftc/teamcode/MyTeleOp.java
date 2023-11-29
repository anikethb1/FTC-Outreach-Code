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

        double leftPower = leftStickY + rightStickY;
        double rightPower = leftStickY - rightStickY;

        frontLeftMotor.setPower(leftPower);
        frontRightMotor.setPower(rightPower);
        backLeftMotor.setPower(leftPower);
        backRightMotor.setPower(rightPower);

        // Control arm
        double armPower = gamepad1.right_stick_x * 0.5; // Limit arm power to 0.5

        armMotor.setPower(armPower);

        // Control claw
        if (gamepad1.x) {
            clawServo.setPosition(1.0); // Open claw
        } else if (gamepad1.y) {
            clawServo.setPosition(0.0); // Close claw
        }
    }

}