package com.jacliu.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jacliu.test.utils.PropertiesReaderUtil;

@Controller
public class LogController {

	@RequestMapping(value = { "/" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String index(HttpServletRequest request) {
		String isTest = PropertiesReaderUtil.getConfigInfo("isTest");
		request.setAttribute("isTest", isTest);
		return "index";
	}

	@RequestMapping(value = { "/projectPoolLog" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	public String projectPoolLog(String env, HttpServletRequest request) {
		request.setAttribute("env", "other");
		return "projectPoolLog";
	}

	@RequestMapping(value = { "/userCenterLog" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	public String userCenterLog(String env, HttpServletRequest request) {
		request.setAttribute("env", env);
		return "userCenterLog";
	}

	@RequestMapping(value = { "/fileServerLog" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	public String fileServerLog(String env, HttpServletRequest request) {
		request.setAttribute("env", env);
		return "fileServerLog";
	}

	@RequestMapping(value = { "/omsWebLog" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String omsWebLog(String env, HttpServletRequest request) {
		request.setAttribute("env", env);
		return "omsWebLog";
	}

	@RequestMapping(value = { "/interfacePlatformLog" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	public String interfacePlatformLog(String env, HttpServletRequest request) {
		request.setAttribute("env", env);
		return "interfacePlatformLog";
	}
}
