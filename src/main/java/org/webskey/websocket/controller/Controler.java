package org.webskey.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.webskey.websocket.model.Message;

@Controller
public class Controler {

	@RequestMapping("/")
	public String index(@RequestParam(value = "name", required = false) String name, ModelMap model) {  
		if(name != null) 
			model.addAttribute("name", name);
		return "index";
	}

	@MessageMapping("/message")
	@SendTo("/broker/conversation")
	public Message messaging(Message message) throws Exception {	
		return message;
	}
}
