package org.firstinspires.ftc.teamcode.opMode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class SixWheel extends LinearOpMode {
    public DcMotor leftFront,leftRear,rightFront,rightRear;
    public double returnBiggerMag(double a,double b){
        if (Math.abs(a)>Math.abs(b)){
            return a;
        } else {
            return b;
        }
    }

    public double signedExp(double a,double b){
        int factor = 1;
        double newA = a;
        if (a>0){
            factor = -1;
            newA*=-1;
        }
        return factor*Math.pow(newA,b);
    }

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
        int bruh = 1;

        waitForStart();

        while (opModeIsActive()){
            double x = gamepad1.left_stick_x;
            double y = gamepad1.left_stick_y;
            double left = signedExp(x,1);
            double right = y;
            double squareCoord =returnBiggerMag(x,y);
            bruh++;
            telemetry.addData("left stick x", gamepad1.left_stick_x);
            telemetry.addData("left stick y", gamepad1.left_stick_y);
            telemetry.addData("test", bruh);
            telemetry.addData("bruh", leftFront.getPower());
            telemetry.update();
            if (squareCoord==x){
                if (y>0){
                    right-= squareCoord;
                } else {
                    right= -squareCoord;
                    left = left + y;
                }
            } else {
                if (x<0){
                    left+= squareCoord;
                } else {
                    left = squareCoord;
                    right= right- x;
                }
            }
            processInputs(left,right);
        }
    }

    public void processInputs(double left,double right){
        leftFront.setPower(left);
        leftRear.setPower(left);
        rightFront.setPower(-right);
        rightRear.setPower(-right);
    }
}
