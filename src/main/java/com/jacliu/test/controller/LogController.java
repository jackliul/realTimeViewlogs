package com.jacliu.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(value = "/omsMessageLog", method = RequestMethod.GET)
	public String omsMessageLog(ModelMap model) {
		return "omsMessageLog";
	}

	@RequestMapping(value = "/userCenterLog", method = RequestMethod.GET)
	public String userCenterLog(ModelMap model) {
		return "userCenterLog";
	}

	@RequestMapping(value = "/omsWebLog", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		return "omsWebLog";
	}

}