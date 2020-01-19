package Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Client.Connection.Client;
import Client.Connection.ClientImpl;

@RestController
public class AppController {

	@Autowired
	Client client;

	@RequestMapping("/")
	public String showPage() {
		client.startConnection();
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

}
