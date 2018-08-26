package org.webskey.websocket.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController implements ErrorController {

	@RequestMapping("/error")
	public ModelAndView handleError(HttpServletRequest request, HttpServletResponse response) {

		int status = response.getStatus();
		String originalUri = request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI).toString();

		if(status == HttpStatus.NOT_FOUND.value()) {
			return new ModelAndView("404", "uri", originalUri);
		}

		return new ModelAndView("exception");
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
