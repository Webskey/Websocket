package demo.myapp;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controler {

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		return "index";
	}
}
