package com.jacliu.test.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.websocket.Session;

public class TailLogThread extends Thread {
	private BufferedReader reader;
	private Session session;

	public TailLogThread(InputStream in, Session session) {
		this.reader = new BufferedReader(new InputStreamReader(in));
		this.session = session;
	}

	@Override
	public void run() {
		try {
			String line;
			while ((line = this.reader.readLine()) != null) {
				this.session.getBasicRemote().sendText(line + "<br>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}