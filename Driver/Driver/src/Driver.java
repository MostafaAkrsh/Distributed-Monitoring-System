import java.io.*;
import java.io.IOException;
import java.net.*;

public class Driver {
	private static Socket driver;
	public static void main(String[] args) throws Exception {

		 driver = new Socket ("localhost",1212);
		
		DataOutputStream dos_driver = new DataOutputStream (driver.getOutputStream());
			    
		dos_driver.writeUTF("I'm Driver ");
		dos_driver.writeUTF("Give Me MA");
		
		receiveFile("MA.exe");

	   	}
	
	public static void receiveFile(String fileName) throws Exception{
	    int bytes = 0;
	    FileOutputStream fileOutputStream = new FileOutputStream(fileName);
	    
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(driver.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    long size = dis.readLong();     // read file size
	    byte[] buffer = new byte[4*1024];
	    while (size > 0 && (bytes = dis.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1) {
	        fileOutputStream.write(buffer,0,bytes);
	        size -= bytes;      // read upto file size
	    }
	    fileOutputStream.close();
	}
}

