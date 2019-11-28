package Client.GoGame;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class GoGameClient 
{
	public static void main(String[] args) throws Exception {
		String ip = "localhost";
        try (var socket = new Socket(ip, 59898)) {
            System.out.println("Enter lines of text then Ctrl+D or Ctrl+C to quit");
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println(in.nextLine());
            }
        }
    }
}
