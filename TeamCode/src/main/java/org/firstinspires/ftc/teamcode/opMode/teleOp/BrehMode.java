package org.firstinspires.ftc.teamcode.opMode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class BrehMode extends LinearOpMode {
    // declaring DcMotor variables
    private DcMotor leftBack,leftFront, rightBack, rightFront;
    @Override
    public void runOpMode() {
        // assigning the DcMotor variables values
        leftBack = hardwareMap.get(DcMotor.class, "leftB");
        leftFront = hardwareMap.get(DcMotor.class, "leftF");
        rightBack = hardwareMap.get(DcMotor.class, "rightB");
        rightFront = hardwareMap.get(DcMotor.class, "rightF");

        // setting the motor run mode of each motor
        leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            double x = gamepad1.right_stick_x;
            double y = gamepad1.left_stick_y;

            telemetry.addData("left stick x", x);
            telemetry.addData("right stick y", y);
            telemetry.update();

            leftBack.setPower(x);
            leftFront.setPower(x);
            rightBack.setPower(-y);
            rightFront.setPower(-y);

        }



    }
}
