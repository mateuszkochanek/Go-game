package ClientApplication.GoGame;

import ClientApplication.GoGame.Connection.Client;

/**
 * Hello world!
 *
 */
public class GoGameClientApplication 
{
	
	public static void main(String[] args){
		Client client = new Client("localhost",59898);
		
		//TODO while true z getMessageFromServer() i sendMessageToServer

		//TODO warunki dla game settings
			//dla nulla odbierz dane i stworz ustawienia,grę.wyślij opcje
			//dla wypelnionego stworz grę
       
    }
}
