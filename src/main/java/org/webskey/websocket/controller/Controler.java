package org.webskey.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.webskey.websocket.model.Message;

@Controller
public class Controler {

	@RequestMapping("/")
	public String index(ModelMap model) {  
		return "index";
	}

	@MessageMapping("/message")
	@SendTo("/broker/conversation")
	public Message messaging(Message message) throws Exception {	
		return message;
	}
}
