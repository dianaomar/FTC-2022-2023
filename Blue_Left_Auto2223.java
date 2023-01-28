package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "blue left 2223", group = "SB^2 Test")


public class Blue_Left_Auto2223 extends LinearOpMode {

    //wheels
    private DcMotor leftBack = null;
    private DcMotor rightBack = null;
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private ColorSensor color_sensor = null;
   
   
    //lift
    //private DcMotor lift = null;
   
    //claw
    //private CRServo leftServo = null;
    //private CRServo rightServo = null;
   
@Override
public void runOpMode() throws InterruptedException{
//public void main() throws InterruptedException{
        rightFront = hardwareMap.get(DcMotor.class, "front_right");
        leftFront = hardwareMap.get(DcMotor.class, "front_left");
        leftBack = hardwareMap.get(DcMotor.class, "back_left");
        rightBack = hardwareMap.get(DcMotor.class, "back_right");
       
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
       leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
       rightBack.setDirection(DcMotorSimple.Direction.FORWARD);
       
        //lift = hardwareMap.get(DcMotor.class, "lift_mechanism");
       
        //servo
        //leftServo = hardwareMap.get(DcMotor.class, "leftServo");
        //rightServo = hardwareMap.get(DcMotor.class, "rightServo");
       // leftServo = hardwareMap.crservo.get("leftServo");
        //rightServo = hardwareMap.crservo.get("rightServo");
       
   
        color_sensor = hardwareMap.colorSensor.get("Color");
       
        color_sensor.enableLed(true);
       
        waitForStart();
           
            while (opModeIsActive()){
               //Forward(200);
                //sleep(500);
                //senseColor();
                telemetry.addData("red", color_sensor.red());
                telemetry.addData("blue", color_sensor.blue());
                telemetry.addData("green", color_sensor.green());
                telemetry.update();
               
               
                /*if (color_sensor.red() > color_sensor.blue()){
                    strafeRight(500);
                }else if (color_sensor.blue() > color_sensor.red()){
                    strafeLeft(500);
                }*/
            }
           
           
}
   
    public void senseColor() {
        if (color_sensor.red()>=10 && color_sensor.red()<=350){
                //printMessage("viewing red");
                telemetry.addData("red", color_sensor.red());
                telemetry.update();
                sleep(400);
                //strafeRight(500);
               
        }else if(color_sensor.green()>=100 && color_sensor.green()<=140){
                //printMessage("viewing green");
                telemetry.addData("green", color_sensor.green());
                telemetry.update();
                sleep(400);
                //strafeLeft(500);
               
        }else{
                telemetry.addData("blue", color_sensor.blue());
                telemetry.update();
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);
        }
    }
   
 
   
    public void turnLeft(int time) {
        //printMessage("turning left");
        leftFront.setPower(-.7);
        leftBack.setPower(.7);
        rightFront.setPower(-.7);
        rightBack.setPower(.7);
        sleep(time);
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }

    //works
    public void turnRight(int time){
        //printMessage("turning right");
        leftFront.setPower(.7);
        leftBack.setPower(-.7);
        rightFront.setPower(.7);
        rightBack.setPower(-.7);
        sleep(time);
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);
    }
   
    public void Forward(int time){
        //printMessage("turning left");
        leftFront.setPower(.7);
        leftBack.setPower(-.7);
        rightFront.setPower(-.7);
        rightBack.setPower(.7);
        sleep(time);
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }


    //works
    public void Backward(int time){
        //printMessage("moving backward");
        leftFront.setPower(-.7);
        leftBack.setPower(.7);
        rightFront.setPower(.7);
        rightBack.setPower(-.7);
        sleep(time);
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }



    public void strafeLeft(int time){
        //printMessage("strafe left");
        leftFront.setPower(-.7);
        leftBack.setPower(-.7);
        rightFront.setPower(-.7);
        rightBack.setPower(-.7);
        sleep(time);
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }
   
    //strafe
    public void strafeRight(int time){
        //printMessage("strafing right");
        leftFront.setPower(.5);
        leftBack.setPower(.5);
        rightFront.setPower(.5);
        rightBack.setPower(.5);
        sleep(time);
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
    }
   
       public void deploy(int value){
        //servo action
       // leftServo.setPower(-.5);
        //rightServo.setPower(.5);
   
    }
   
    public void collect(){
        //servo action
        //leftServo.setPower(.5);
        //rightServo.setPower(-.5);
    }
   
    public void printMessage(String message) {
        telemetry.addData(message,"");
        telemetry.update();
    }
   

   
   
   
   
}

