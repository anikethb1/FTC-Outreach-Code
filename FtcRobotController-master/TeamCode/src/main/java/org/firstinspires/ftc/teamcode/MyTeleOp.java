package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "MyTeleOp")
public class MyTeleOp extends OpMode {

    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;

    /*
    DcMotor armMotor;
    Servo clawServo;
     */

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");

        /*
        armMotor = hardwareMap.dcMotor.get("armMotor");
        clawServo = hardwareMap.servo.get("clawServo");'
            */

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);

    }

    @Override
    public void loop() {

        if (gamepad1.left_stick_y > 0.3) {
            frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
            backLeftMotor.setDirection(DcMotor.Direction.FORWARD);
            backRightMotor.setDirection(DcMotor.Direction.FORWARD);

            frontLeftMotor.setPower(0.6);
            frontRightMotor.setPower(0.6);
            backLeftMotor.setPower(0.6);
            backRightMotor.setPower(0.6);
        }

        if (gamepad1.left_stick_y < -0.3) {
            frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
            frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
            backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
            backRightMotor.setDirection(DcMotor.Direction.REVERSE);

            frontLeftMotor.setPower(0.6);
            frontRightMotor.setPower(0.6);
            backLeftMotor.setPower(0.6);
            backRightMotor.setPower(0.6);
        }

        if (0.3 > gamepad1.left_stick_y && gamepad1.left_stick_y > -0.3) {
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
        }

        if (gamepad1.left_stick_x >= 0.3) {
            strafeLeft();
        } else if (gamepad1.left_stick_x <= 0.3) {
            strafeRight();
        }

        if (gamepad1.left_stick_x < 0.3 && gamepad1.left_stick_y > 0.3) {
            moveFrontLeft();
        } else if (gamepad1.left_stick_x > 0.3 && gamepad1.left_stick_y > 0.3) {
            moveFrontRight();
        } else if (gamepad1.left_stick_x < 0.3 && gamepad1.left_stick_y < 0.3) {
            moveBackLeft();
        } else if (gamepad1.left_stick_x > 0.3 && gamepad1.left_stick_y < 0.3) {
           moveBackRight();
        }

        /*

        double leftStickY = gamepad1.left_stick_y;
        double rightStickY = gamepad1.right_stick_y;

        double leftPower = leftStickY + rightStickY;
        double rightPower = leftStickY - rightStickY;

        if (leftStickY > 0 || rightStickY > 0) {
            frontLeftMotor.setPower(leftPower);
            frontRightMotor.setPower(rightPower);
            backLeftMotor.setPower(leftPower);
            backRightMotor.setPower(rightPower);
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

         */

        /*
        else if (gamepad1.right_stick_y > 0.3 ) {
            armMotor.setPower(gamepad1.right_stick_y / 2);
        }



        // double armPower = gamepad1.right_stick_x / 2;
        // armMotor.setPower(armPower);



        if (gamepad1.x) {
            clawServo.setPosition(1.0);
        } else if (gamepad1.y) {
            clawServo.setPosition(0.0);
        }
         */
    }

    public void strafeLeft() {
        frontLeftMotor.setPower(-0.6);
        backLeftMotor.setPower(0.6);
        frontRightMotor.setPower(0.6);
        backRightMotor.setPower(-0.6);
    }

    public void strafeRight() {
        frontLeftMotor.setPower(0.6);
        backLeftMotor.setPower(-0.6);
        frontRightMotor.setPower(-0.6);
        backRightMotor.setPower(0.6);
    }

    public void turnLeft() {
        frontLeftMotor.setPower(-0.6);
        backLeftMotor.setPower(-0.6);
        frontRightMotor.setPower(-0.6);
        backRightMotor.setPower(-0.6);
    }

    public void turnRight() {
        frontLeftMotor.setPower(0.6);
        backLeftMotor.setPower(0.6);
        frontRightMotor.setPower(0.6);
        backRightMotor.setPower(0.6);
    }

    public void moveFrontRight() {
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0.6);
        frontRightMotor.setPower(0.6);
        backRightMotor.setPower(0);
    }

    public void moveBackRight() {
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(-0.6);
        frontRightMotor.setPower(-0.6);
        backRightMotor.setPower(0);
    }

    public void moveFrontLeft() {
        frontLeftMotor.setPower(0.6);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0.6);
    }

    public void moveBackLeft() {
        frontLeftMotor.setPower(-0.6);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(-0.6);
    }


}