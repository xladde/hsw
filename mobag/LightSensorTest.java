import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

/**
 * Diese Klasse bestimmt den vom Lichtsensor ermitteleten Wert und gibt diesen
 * auf dem Bildschirm aus.
 * 
 * @author Paul Weichbrodt, Tom Riske, Tobias Baade
 * @version 10.01.2012
 * 
 */
public class LightSensorTest {
	/**
	 * Ist der Lichtsensor an Sensorport 1.
	 */
	public static LightSensor lightSensor = new LightSensor(SensorPort.S1);
	/**
	 * Siehe Klassenbeschreibung.
	 * @param args Es brauchen keine Parameter übergeben werden.
	 */
	public static void main(String[] args) throws InterruptedException {
		
		while(true){
			LCD.clear();
			LCD.drawInt(lightSensor.getNormalizedLightValue(), 0, 0);
			Thread.sleep(1000);
		}
	}

}
