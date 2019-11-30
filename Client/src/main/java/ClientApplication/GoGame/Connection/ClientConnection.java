package ClientApplication.GoGame.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.SetGameOptions;
import Server.ServerMessage.GameSettings;
import Server.ServerMessage.MoveInfo;
import Server.ServerMessage.OponentMove;
import Server.ServerMessage.ServerMessage;

public class ClientConnection implements Runnable {
		Client client;
	 	private Socket socket;
	    private ObjectInputStream inputStream;
	    private ObjectOutputStream outputStream;


	    public ClientConnection(String ipAdress, int port) throws UnknownHostException, IOException {
			this.socket = new Socket(ipAdress,port);
		}

		@Override
	    public void run() {
	        try {
	        	setup();
	            processCommands();
	        } catch (Exception e) {
	            e.getStackTrace();
	        } finally {
	            try { 
	                socket.close();
	            } catch (IOException e) {
	                e.getStackTrace();
	            }
	        }
	      
	    }
		
		private void setup() throws IOException {
			 System.out.print("Seting input and output... ");
	            outputStream = new ObjectOutputStream(socket.getOutputStream());
	            inputStream = new ObjectInputStream(socket.getInputStream());
	            System.out.println("Done");
		}
		
		private void processCommands() throws ClassNotFoundException, IOException {
            while (inputStream != null) {
				ServerMessage serverMessage = this.getMessageFromServer();
				 if (this.client != null) {
	                 this.client.getServerMessage(serverMessage);
	             }
            }

        }
		
	    public ServerMessage getMessageFromServer() throws ClassNotFoundException, IOException {
	        return (ServerMessage) inputStream.readObject();
	    }
	    
	    public void sendMessageToServer(ClientMessage message) throws IOException {
	        outputStream.writeObject(message);
	        outputStream.flush();
	    }

		public void setClient(Client client) {
			this.client = client;
		}
}
