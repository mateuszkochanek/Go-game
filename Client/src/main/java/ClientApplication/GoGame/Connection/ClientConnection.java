package ClientApplication.GoGame.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import Server.ServerMessage.ServerMessage;
import javafx.application.Platform;
import javafx.concurrent.Task;

public class ClientConnection {
	protected Client client;
	protected ConnectionThread connectionThread;

	public ClientConnection(String ipAdress, int port, Client client) throws UnknownHostException, IOException {
		this.client = client;
		connectionThread = new ConnectionThread(ipAdress, port);
	}
	
	public void startConnection() {
		connectionThread.start();
	}

	public void sendMessageToServer(ClientMessage message) throws IOException {
		connectionThread.outputStream.writeObject(message);
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private class ConnectionThread extends Thread {
		private Socket socket;
		private ObjectInputStream inputStream;
		private ObjectOutputStream outputStream;
		private int port;
		private String ipAdress;
		
		
		
		public ConnectionThread(String ipAdress, int port) {
			this.ipAdress = ipAdress;
			this.port = port;
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
				System.out.println(e.getMessage());
			} finally {
				try {
					socket.close(); // TODO zrobie nie tak zeby klient mogl spokojnie poczekac na serwer.
				} catch (IOException e) {
					e.getStackTrace();
				}
			}

		}
		
		private void setup(){
			while(true) {
			    try {
			    	this.socket = new Socket(ipAdress, port);
			        break; // We connected! Exit the loop.
			    } catch(IOException e) {
			        System.out.println("Nie udalo się połączyc, proboje jeszcze raz.");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		private void processCommands() throws ClassNotFoundException, IOException {
			while (inputStream != null) {
				ServerMessage serverMessage = (ServerMessage) this.inputStream.readObject();
				if (client != null) { //TODO co jeżeli client null?
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							client.getServerMessage(serverMessage);
						}
					});
				}
			}
		}

	}
}
