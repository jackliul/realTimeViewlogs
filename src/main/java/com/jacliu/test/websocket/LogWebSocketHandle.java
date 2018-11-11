package com.jacliu.test.websocket;

import java.io.IOException;
import java.io.InputStream;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.jacliu.test.utils.PropertiesReaderUtil;

@ServerEndpoint("/log/{env}/{projectName}")
public class LogWebSocketHandle {
	private Process process;
	private InputStream inputStream;

	@OnOpen
	public void onOpen(@PathParam("env") String env, @PathParam("projectName") String projectName, Session session) {
		try {
			String logPath = getLogPath(env, projectName);
			System.out.println("###  " + projectName + " :: " + logPath + "  #### ");

			this.process = Runtime.getRuntime().exec("tail -200f " + logPath);
			this.inputStream = this.process.getInputStream();

			TailLogThread thread = new TailLogThread(this.inputStream, session);
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnClose
	public void onClose() {
		try {
			if (this.inputStream != null) {
				this.inputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (this.process != null) {
			this.process.destroy();
		}
	}

	@OnError
	public void onError(Throwable thr) {
		thr.printStackTrace();
	}

	private String getLogPath(String env, String projectName) {
		String logPathKey = env + "." + projectName + "." + "log.path";

		String logPath = PropertiesReaderUtil.getConfigInfo(logPathKey);
		System.out.println("logPathKey :: " + logPathKey);
		System.out.println("logPath :: " + logPath);
		return logPath;
	}
}
