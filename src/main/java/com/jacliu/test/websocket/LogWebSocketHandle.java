package com.jacliu.test.websocket;

import java.io.IOException;
import java.io.InputStream;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/log/{projectName}")
public class LogWebSocketHandle {

	private Process process;
	private InputStream inputStream;

	/**
	 * 新的WebSocket请求开启
	 */
	@OnOpen
	public void onOpen(@PathParam(value = "projectName") String projectName, Session session) {
		try {

			String logPath = getLogPath(projectName);
			System.out.println("###  " + projectName + " :: " + logPath + "  #### ");

			// 执行tail -f命令
			process = Runtime.getRuntime().exec("tail -200f " + logPath);
			inputStream = process.getInputStream();

			// 一定要启动新的线程，防止InputStream阻塞处理WebSocket的线程
			TailLogThread thread = new TailLogThread(inputStream, session);
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * WebSocket请求关闭
	 */
	@OnClose
	public void onClose() {
		try {
			if (inputStream != null)
				inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (process != null)
			process.destroy();
	}

	@OnError
	public void onError(Throwable thr) {
		thr.printStackTrace();
	}

	private String getLogPath(String projectName) {
		String logPath = null;
		if ("omsMessage".equals(projectName)) {
			logPath = "/home/log/message/message-info.log";
		}
		if ("omsWeb".equals(projectName)) {
			logPath = "/home/tomcatHome/tomcat_oms_back/logs/catalina.out";
		}
		if ("userCenter".equals(projectName)) {
			logPath = "/home/tomcatHome/tomcat_user_center/logs/catalina.out";
		}
		return logPath;
	}

}