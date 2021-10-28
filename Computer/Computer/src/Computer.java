import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Computer {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Connect to the Server
		Socket ConnectingToServer = new Socket("localhost", 1111);
		// Make Computer port
		ServerSocket ComputerPort = new ServerSocket(1212);

		while (true) {

			// Delegate to new thread to communicate to server
			ComputerHandlerServer S = new ComputerHandlerServer(ConnectingToServer);
			S.start();

			Socket node = ComputerPort.accept();
			// Delegate to new thread to communicate with thread
			ComputerHandlerNode N = new ComputerHandlerNode(node);

			N.start();
		}

	}

}
