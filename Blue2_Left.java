package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@Autonomous(name="Basic: Linear OpMode", group="Linear OpMode")

public class Blue2_Left extends LinearOpMode {

 // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor armmotor;
    private DcMotor acimotor;
    private Servo solservo;
    private Servo sagservo;
    
    private int leftPos;
    private int rightPos;
    private int armPos;
    private int aciPos;
    private int lservoPos;
    private int rservoPos;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        armmotor = hardwareMap.get(DcMotor.class, "arm_motor");
        acimotor = hardwareMap.get(DcMotor.class, "aci_motor");
        solservo = hardwareMap.get(Servo.class, "left_servo");
        sagservo = hardwareMap.get(Servo.class, "right_servo");
        
        
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        acimotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        
        leftPos = 0;
        rightPos = 0;
        armPos = 0;
        aciPos = 0;
        
        waitForStart();
        
        // Çizgiye Bırakma
        
        solservo.setPosition(-0.64);
        sagservo.setPosition(0.32);
        sleep(500);
        drive(0,0,0,300,1);
        sleep(2000);
        drive(0,0,0,-1000,1);
        sleep(4000);
        drive(-500,-500, 0, 0,0.5);
        sleep(1000);
        drive(-250,250,0,0,1);
        sleep(1000);
        sagservo.setPosition(0);
        
        drive(0,0,0,300,1);
        sleep(3000);
        drive(240,-240,0,0,1);
        sleep(1500);
        drive(400,400, 0, 0,0.5);
        sleep(3000);
        //Kolu indirme
        
        
    }
    
    

    private void drive(int leftTarget, int rightTarget,int armTarget, double aciTarget,  double speed){
        leftPos += leftTarget;
        rightPos += rightTarget;
        armPos += armTarget;
        aciPos += aciTarget;
        
        leftDrive.setTargetPosition(leftPos);
        rightDrive.setTargetPosition(rightPos);
        armmotor.setTargetPosition(armPos);
        acimotor.setTargetPosition(aciPos);
        
        
        
        leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        acimotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        
        leftDrive.setPower(speed);
        rightDrive.setPower(speed);
        armmotor.setPower(speed);
        acimotor.setPower(speed);
        
        
        
        while(opModeIsActive() && leftDrive.isBusy() && rightDrive.isBusy()){
            idle();
        }
    
    }
}



