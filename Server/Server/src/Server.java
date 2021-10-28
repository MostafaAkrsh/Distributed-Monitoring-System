import java.io.IOException;
import java.net.*;
import java.io.*;

public class Server {
	
	static Socket Computer;

	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(1111);
		
	    Computer = server.accept();
		DataOutputStream dos = new DataOutputStream(Computer.getOutputStream());
		DataInputStream dis = new DataInputStream(Computer.getInputStream());
		
		dos.writeUTF("\n You're connected to the server \n");

		while(true){
		

	    String st = new String(dis.readUTF());
	    	    
	    System.out.print(st);
	    
	    if(st.contains("I'm Driver"))
	    {
	    	dos.writeUTF("Send to driver the Mobile Agent");
	    }
	    
	    if(st.contains("traffic light 1 is RED"))
	    {
	    dos.writeUTF("server recieved data successfully");	    	
		sendFile("MA1.exe");
	    }
	    else if (st.contains("street 2 is jammed"))
	    {
	    dos.writeUTF("server recieved data successfully");	    	
		sendFile("MA2.exe");
	    }
	    else if (st.contains("bridge is costructed"))
	    {
	    dos.writeUTF("server recieved data successfully");	    	
	    sendFile("MA3.exe");
	    }
	    
	    else
	    {
		    dos.writeUTF("server recieved unrecognized data");	    	
		    sendFile("MAD.exe");
	    }
	    
		}
	}
	
	public static void sendFile(String path) throws Exception {
		int bytes = 0;
		File file = new File(path);
		FileInputStream fileInputStream = new FileInputStream(file);

		DataOutputStream dos = null;

		try {
			dos = new DataOutputStream(Computer.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// send file size
		dos.writeLong(file.length());
		// break file into chunks
		byte[] buffer = new byte[4 * 1024];
		while ((bytes = fileInputStream.read(buffer)) != -1) {
			dos.write(buffer, 0, bytes);
			dos.flush();
		}
		fileInputStream.close();
	}
	

}
