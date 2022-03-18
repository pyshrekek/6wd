package org.firstinspires.ftc.teamcode.opMode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class daniel extends LinearOpMode {

    public DcMotor leftFront,leftRear,rightFront,rightRear;

    @Override
    public void runOpMode() throws InterruptedException {
        rightFront = hardwareMap.get(DcMotor.class,"rightFront");
        leftFront = hardwareMap.get(DcMotor.class,"leftFront");
        rightRear = hardwareMap.get(DcMotor.class,"rightRear");
        leftRear = hardwareMap.get(DcMotor.class,"leftRear");
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive()){
            double leftStick = gamepad1.left_stick_x;
            double rightStick = gamepad1.right_stick_y;
            double leftDrive = leftStick;
            double rightDrive = rightStick;
            telemetry.addData("leftStick", gamepad1.left_stick_y);
            telemetry.addData("rightStick", gamepad1.right_stick_y);
            telemetry.update();

            drive(leftDrive, rightDrive);
        }
    }

    public void drive(double leftDrive, double rightDrive){
        // CONTROLS THE BOT USING 2 STICKS
        // LEFT STICK CONTROLS LEFT WHEELS
        // RIGHT STICKS CONTROLS RIGHT WHEELS
        leftFront.setPower(leftDrive);
        leftRear.setPower(leftDrive);
        rightFront.setPower(rightDrive);
        rightRear.setPower(rightDrive);
    }
}
