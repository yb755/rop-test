package com.vbgps.rop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rop.session.Session;
import com.rop.session.SessionManager;

public class SampleSessionManager implements SessionManager {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private final Map<String, Session> sessionCache = new ConcurrentHashMap<String, Session>(128, 0.75f, 32);

	public void addSession(String sessionId, Session session) {
		sessionCache.put(sessionId, session);
	}

	public Session getSession(String sessionId) {
		return sessionCache.get(sessionId);
	}

	public void removeSession(String sessionId) {
		sessionCache.remove(sessionId);
	}

}
