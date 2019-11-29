package ClientApplication.GoGame.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;



public class Client { // zamykanie i otwieranie połączenia
	private ObjectOutputStream output = null;
	private ObjectInputStream input = null;
	private Socket socket = null;
	
	public Client(String ipAdress,int port) {
		this.initializeClientConnection(ipAdress,port);
	}
	
	//this method creates connection and output/input object streams
	private void initializeClientConnection(String ipAdress,int port) {
		
			try {
				this.setSocket(new Socket(ipAdress,port));
				System.out.println("socket created");
				this.setInput(new ObjectInputStream(socket.getInputStream()));
		        this.setOutput(new ObjectOutputStream(socket.getOutputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
	         
	}
	
	public void sendMessageToServer (ClientMessage message) throws IOException {
        	ClientMessage newMessage = message;
			output.writeObject(newMessage);
	}
	
	public void getMessageFromServer() throws IOException{
		
	}
	
	
	public void closeClientConnection() {
		try {
			output.close();
			input.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public ObjectOutputStream getOutput() {
		return output;
	}


	public void setOutput(ObjectOutputStream output) {
		this.output = output;
	}


	public ObjectInputStream getInput() {
		return input;
	}


	public void setInput(ObjectInputStream input) {
		this.input = input;
	}


	public Socket getSocket() {
		return socket;
	}


	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}