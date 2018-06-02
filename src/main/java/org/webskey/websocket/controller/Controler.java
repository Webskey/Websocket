package org.webskey.websocket.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.webskey.websocket.model.Message;

@Controller
public class Controler {

	@RequestMapping("/")
	public String index(HttpServletRequest request, ModelMap model) {  
		//String ipAddress = request.getHeader("X-FORWARDED-FOR"); 
		model.addAttribute("ip", request.getRemoteAddr());
		
		return "index";
	}

	@MessageMapping("/message")
	@SendTo("/broker/conversation")
	public Message messageReceived(Message message) throws Exception {
		Thread.sleep(1000); // simulated delay		
		return new Message(message.getName(), message.getMessage(), message.getIp());
	}

}
