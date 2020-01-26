package Client.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Client.AppController;
import Client.GoGame.Entities.ClientMessages.ClientMessage;
import Server.ServerMessage.EndGame;
import Server.ServerMessage.ServerMessage;

public abstract class ClientConnection {
	protected ConnectionThread connectionThread;
	@Autowired
	AppController appController;
	
	public ClientConnection(String ipAdress, int port) throws UnknownHostException, IOException {
		connectionThread = new ConnectionThread(ipAdress, port);
	}
	
	public void startConnection() {
		connectionThread.start();
	}
	

	public void closeConnection() {
		connectionThread.closeConnection();
	}

	public void sendMessageToServer(ClientMessage message) throws IOException {
		connectionThread.outputStream.writeObject(message);
	}

	private class ConnectionThread extends Thread {
		private Socket socket;
		private ObjectInputStream inputStream;
		private ObjectOutputStream outputStream;
		private int port;
		private String ipAdress;
		private boolean keepRunning;
		
		
		
		public ConnectionThread(String ipAdress, int port) {
			this.ipAdress = ipAdress;
			this.port = port;
			keepRunning = true;
		}

		public void closeConnection() {
			keepRunning = false;
		}

		@Override
		public void run() {
			read();
		}

		public void read() {
			try {
				setup();
				processCommands();
			} catch (Exception e) {
				e.getStackTrace();
				System.out.println("jestem w ClientConnection read: " + e.getMessage()); //TODO handle
			} finally {
				try {
					socket.close(); // TODO zrobie nie tak zeby klient mogl spokojnie poczekac na serwer.
				} catch (IOException e) {
					e.getStackTrace();
				}
			}

		}
		
		private void setup(){
			int i = 0;
			while(true) {
			    try {
			    	this.socket = new Socket(ipAdress, port);
			        break; // We connected! Exit the loop.
			    } catch(IOException e) {
			        System.out.println("Nie udalo się połączyc, proboje jeszcze raz: " + i);
			        i++;
			        try {
			            TimeUnit.SECONDS.sleep(3);
			        } catch(InterruptedException ie) {
			            // Interrupted.
			        }
			    }
			}
			try {
				
				this.outputStream = new ObjectOutputStream(socket.getOutputStream());
				this.inputStream = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				System.out.println("Catch block w setup przy tworzeniu outputu i inputu");// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		private void processCommands() throws ClassNotFoundException, IOException {
			while (inputStream != null) {
				if(!keepRunning) {
					socket.close();
					break;
				}

				ServerMessage serverMessage;
				serverMessage = (ServerMessage) this.inputStream.readObject();
				appController.connected();//TODO Jak dac znac kontrolerowi?
				
				System.out.println(serverMessage.getClass());
				if(serverMessage instanceof EndGame)
					keepRunning = false;
			}

		}
	}

}
