import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class ServoTest 
{
	public static void main(String[] args) throws InterruptedException
	{
		final GpioController gpio = GpioFactory.getInstance();
		
		GpioPinDigitalOutput myServo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,   // PIN NUMBER
                "My LED",           // PIN FRIENDLY NAME (optional)
                PinState.LOW);		
		
		//Servo sources:
		//http://en.wikipedia.org/wiki/Servo_control
		//http://upload.wikimedia.org/wikipedia/commons/b/b7/Sinais_controle_servomotor.JPG
		//http://learn.adafruit.com/adafruits-raspberry-pi-lesson-8-using-a-servo-motor/servo-motors
		//1000 == -90°
		//1500 == 0°
		//2000 == 90°
		
		while (true)
		{
			for (int i=0; i<100; i++)
			{
				myServo.high();
				java.lang.Thread.sleep(0, 1000);
				myServo.low();
				java.lang.Thread.sleep(0, 19000);
			}
			
			for (int i=0; i<100; i++)
			{
				myServo.high();
				java.lang.Thread.sleep(0, 2000);
				myServo.low();
				java.lang.Thread.sleep(0, 18000);
			}
		}
	
	}
}
