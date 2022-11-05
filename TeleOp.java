package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range; 


@TeleOp(name = "TeleOp2223", group = "Mecanum")
public class TeleOp2223 extends LinearOpMode {
    
    private ElapsedTime runtime = new ElapsedTime();
    
    //wheels
    private DcMotor leftBack = null; 
    private DcMotor rightBack = null; 
    private DcMotor leftFront = null; 
    private DcMotor rightFront = null; 
    
    
    //attatchments 
    //lift 
    //private DcMotor lift = null; 
    
    //claw 
    //private DcMotor leftServo = null;
    //private DcMotor rightServo = null;
    
    @Override
    public void runOpMode() {
        printMessage("Initialized"); 
        
        //wheels
        rightFront = hardwareMap.get(DcMotor.class, "front_right");
        leftFront = hardwareMap.get(DcMotor.class, "front_left");
        leftBack = hardwareMap.get(DcMotor.class, "back_left");
        rightBack = hardwareMap.get(DcMotor.class, "back_right");
        
        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE); 
        
        //attatchments
        //lift = hardwareMap.get(DcMotor.class, "lift_mechanism");
        
        //leftServo = hardwareMap.get(DcMotor.class, "leftServo");
        //rightServo = hardwareMap.get(DcMotor.class, "rightServo");
        
        double x1;
        double y1;

        waitForStart();
        runtime.reset();
        
        while (opModeIsActive()) {
            
            double spin = gamepad1.right_stick_x; 
        
        if (Math.abs(spin) > 0.1){
            rightFront.setPower(-spin);
            rightBack.setPower(-spin);
            
            leftBack.setPower(spin);
            leftFront.setPower(spin);
        }else{
            y1 = -gamepad1.left_stick_y;           
            x1 = gamepad1.left_stick_x;       

            leftFront.setPower(y1);
            rightFront.setPower(y1);
            leftBack.setPower(x1);  
            rightBack.setPower(x1);  
        }
            
        
        //ATTACHMENTS
        
        //lift
        /*if(gamepad2.dpad_up){
            lift.setPower(1);
        } 
        if(gamepad2.dpad_down){
            lift.setPower(-1); 
        }*/
        
        //servo MOTIONS 
        /*if(gamepad2.a){
            //claw.setPower(1);
            leftServo.setPower(.5);
            rightServo.setPower(-.5);
            

        } */
        /*if(gamepad2.b){
            //claw.setPower(-1);
            leftServo.setPower(-.5);
            rightServo.setPower(.5);
        }*/
        
        

    }
    } 
   public void printMessage(String message) {
        telemetry.addData(message,"");
        telemetry.update();
    }
    
    }//this is a TeleOp file
