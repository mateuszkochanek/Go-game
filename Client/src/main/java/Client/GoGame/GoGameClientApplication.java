package Client.GoGame;

import Client.GoGame.Connection.Client;

/**
 * Hello world!
 *
 */
public class GoGameClientApplication 
{
	
	public static void main(String[] args){
		Client client = new Client("localhost",59898);
       
    }
}
