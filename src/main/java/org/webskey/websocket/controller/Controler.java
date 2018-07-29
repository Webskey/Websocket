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
	public String index(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "room", required = false) Integer roomNum, ModelMap model) { 

		if(name != null) 
			model.addAttribute("name", name);

		if(roomNum != null) 
			model.addAttribute("roomNum", roomNum);

		return "index";
	}

	@MessageMapping("/message/{num}")
	@SendTo("/broker/conversation/{num}")
	public Message messaging(Message message) throws Exception {	
		return message;
	}

	@MessageMapping("/message/")
	@SendTo("/broker/conversation/")
	public Message messagin(Message message) throws Exception {	
		return message;
	}
}
