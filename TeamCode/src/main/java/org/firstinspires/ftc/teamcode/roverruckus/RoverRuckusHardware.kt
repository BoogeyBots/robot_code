package org.firstinspires.ftc.teamcode.roverruckus

import android.os.PowerManager
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.Servo


class RoverRuckusHardware {
    private lateinit var leftMotor: DcMotor
    private lateinit var rightMotor: DcMotor

    lateinit var leftArm: DcMotor
    lateinit var rightArm: DcMotor

    private lateinit var hookServo: Servo
    private lateinit var lockServo: Servo

    lateinit var markerServo: Servo

    var leftArmPower: Double = 0.0
        set(value) {
            if (value != field) {
                field = value
                leftArm.power = field
            }
        }

    var rightArmPower: Double = 0.0
        set(value) {
            if (value != field) {
                field = value
                rightArm.power = field
            }
        }

    var leftMotorPower: Double = 0.0
        // Custom setters for caching system
        set(value) {
            // Only set the power of the motor if the last "frame's" power is
            // different from the current one
            if (value != field) {
                field = value
                leftMotor.power = field
            }
        }

    var rightMotorPower: Double = 0.0
        set(value) {
            if (value != field) {
                field = value
                rightMotor.power = field
            }
        }

    var hookServoPos: Double = 0.0
        set(value) {
            if (value != field) {
                field = value
                hookServo.position = field
            }
        }

    var lockServoPos: Double = 0.0
        set(value) {
            if (value != field) {
                field = value
                lockServo.position = field
            }
        }

    fun init(hardwareMap: HardwareMap){
        leftMotor = hardwareMap.get(DcMotor::class.java, "l_mov")
        rightMotor = hardwareMap.get(DcMotor::class.java, "r_mov")

        leftMotor.direction = DcMotorSimple.Direction.REVERSE
        rightMotor.direction = DcMotorSimple.Direction.FORWARD
        leftMotor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        rightMotor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        leftMotor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        rightMotor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

        leftArm = hardwareMap.get(DcMotor::class.java, "l_arm")
        rightArm = hardwareMap.get(DcMotor::class.java, "r_arm")

        leftArm.direction = DcMotorSimple.Direction.FORWARD
        rightArm.direction = DcMotorSimple.Direction.REVERSE
        leftArm.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        rightArm.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER

        hookServo = hardwareMap.get(Servo::class.java, "hook")
        lockServo = hardwareMap.get(Servo::class.java, "lock")

        markerServo = hardwareMap.get(Servo::class.java, "marker")
    }
}
