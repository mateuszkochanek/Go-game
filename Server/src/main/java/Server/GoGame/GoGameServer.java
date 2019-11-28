package Server.GoGame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class GoGameServer 
{
	public static void main(String[] args) throws Exception {
        try (var listener = new ServerSocket(59898)) {
            System.out.println("The GOGAME server is running...");
            var pool = Executors.newFixedThreadPool(20);
            while (true) {
                pool.execute(new Player(listener.accept()));
            }
        }
    }

    private static class Player implements Runnable {
        private Socket socket;

        Player(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Connected: " + socket);
            try {
                var in = new Scanner(socket.getInputStream());
                var out = new PrintWriter(socket.getOutputStream(), true);
                while (in.hasNextLine()) {
                    out.println(in.nextLine().toUpperCase());
                }
            } catch (Exception e) {
                System.out.println("Error:" + socket);
            } finally {
                try { socket.close(); } catch (IOException e) {}
                System.out.println("Closed: " + socket);
            }
        }
    }
}
