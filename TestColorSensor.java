package org.firstinspires.ftc.teamcode;
 
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
 
@Autonomous
public class TestColorSensor extends LinearOpMode {
    // Define a variable for our color sensor
    ColorSensor color;
    private DcMotor leftBack = null; 
    private DcMotor rightBack = null; 
    private DcMotor leftFront = null; 
    private DcMotor rightFront = null; 
    @Override
    public void runOpMode() {
        // Get the color sensor from hardwareMap
        color = hardwareMap.get(ColorSensor.class, "Color");
        
        // Wait for the Play button to be pressed
        waitForStart();
        rightFront = hardwareMap.get(DcMotor.class, "front_right");
        leftFront = hardwareMap.get(DcMotor.class, "front_left");
        leftBack = hardwareMap.get(DcMotor.class, "back_left");
        rightBack = hardwareMap.get(DcMotor.class, "back_right");
        //add claw/linear slide hardware map here
 
        // While the Op Mode is running, update the telemetry values.
        while (opModeIsActive()) {
            telemetry.addData("Red", color.red());
            telemetry.addData("Green", color.green());
            telemetry.addData("Blue", color.blue());
            telemetry.update();
         if (color.red()>color.blue()) {
            strafeLeft(1000);
            sleep(1000);
          //basically if you add an else statement here it should behave as if it were detecting blue
          //add claw/linear slide stuff here
        }           
        }
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    //this works
    void turnright(int input) {
        leftBack.setPower(-.5);
        rightBack.setPower(.5);
        leftFront.setPower(-.5);
        rightFront.setPower(-.5);
        sleep(input); 
        leftBack.setPower(0);
        rightBack.setPower(0); 
    }// this works
    void turnleft(int input) {
        leftBack.setPower(.5);
        rightBack.setPower(-.5);
        leftFront.setPower(.5);
        rightFront.setPower(.5);
        sleep(input); 
        leftBack.setPower(0);
        rightBack.setPower(0); 
    }
    //this works
    void forward(int input){
        leftBack.setPower(-.5);
        rightBack.setPower(-.5);
        leftFront.setPower(.5);
        rightFront.setPower(-.5);
        sleep(input); 
        leftBack.setPower(0);
        rightBack.setPower(0); 
        leftFront.setPower(0);
        rightFront.setPower(0);
    }// this works
    void backward(int input){
        leftBack.setPower(.5);
        rightBack.setPower(.5);
        leftFront.setPower(-.5);
        rightFront.setPower(.5);
        sleep(input); 
        leftBack.setPower(0);
        rightBack.setPower(0); 
    }
    //this works
    void strafeLeft(int input){
        leftFront.setPower(.5);
        leftBack.setPower(.5);
        rightBack.setPower(.5);
        rightFront.setPower(-.5);
        sleep(input); 
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);
    }
    //this works
    void strafeRight(int input){
        leftBack.setPower(-.5);
        rightBack.setPower(-.5);
        leftFront.setPower(-.5);
        rightFront.setPower(.5);
        sleep(input); 
        leftBack.setPower(0);
        rightBack.setPower(0); 
    }
}
