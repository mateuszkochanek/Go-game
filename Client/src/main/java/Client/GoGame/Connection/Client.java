package Client.GoGame.Connection;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
	private ObjectOutputStream output = null;
	private ObjectInputStream input = null;
	private Socket socket = null;
	
	public Client(String ipAdress,int port) {
		
	}
	
	
	private void initializeClientConnection(String ipAdress,int port) {
		
	}
}
