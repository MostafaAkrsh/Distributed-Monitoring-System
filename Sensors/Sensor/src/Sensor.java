import java.io.*;
import java.net.*;

public class Sensor {

	public static void main(String[] args) throws IOException {

		/* Connect To Computer and send to it data */
	Socket trafficNode = new Socket ("localhost",1212);
//	Socket cameraNode = new Socket ("localhost",1212);
//	Socket sensorNode = new Socket ("localhost",1212);
		
	DataOutputStream dos_traffic = new DataOutputStream (trafficNode.getOutputStream());
//	DataOutputStream dos_camera = new DataOutputStream (cameraNode.getOutputStream());
//	DataOutputStream dos_sensor = new DataOutputStream (sensorNode.getOutputStream());
		    

		dos_traffic.writeUTF("traffic light 1 is RED");		

	
	dos_traffic.close();
  //  dos_camera.close();
  //  dos_sensor.close();
    
    trafficNode.close();
   // cameraNode.close();
   // sensorNode.close();

	
	}

}
