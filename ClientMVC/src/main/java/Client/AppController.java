package Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Client.Connection.Client;
import Client.Connection.ClientImpl;
import Client.GoGame.Entities.ClientMessages.SetGameOptions;

@RestController
public class AppController {

	@Autowired
	Client client;

	@RequestMapping("/")
	public String showPage() {
		return "redirect:/waiting";
	}
	
	@RequestMapping("/waiting")
	public String showWaitPage() {
		return "wait-for-server";
	}
	
	@RequestMapping("/connecte")
	public String showConnectedPage() {
		return "connected";
	}
	
	public String connected() {
		return "redirect:/connected";
	}
	
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public SetGameOptions send(SetGameOptions message) throws Exception {
	    return new SetGameOptions(1, "singleplayer");
	}

}
