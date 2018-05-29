package demo.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class Controler {

	@RequestMapping("/")
	public String index(HttpServletRequest request, ModelMap model) {  
		//String ipAddress = request.getHeader("X-FORWARDED-FOR"); 
		model.addAttribute("ip", request.getRemoteAddr());
		
		return "index";
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message, String me) throws Exception {
		Thread.sleep(1000); // simulated delay
		me = message.getIp();
		return new Greeting(HtmlUtils.htmlEscape(message.getName() + " : " + message.getMessage() + " : " + message.getIp()), me);
	}

}
