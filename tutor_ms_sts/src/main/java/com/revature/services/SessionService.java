package com.revature.services;

import java.util.List;

import com.revature.beans.Session;

public interface SessionService {

	public Session addSession(Session s);

	public Session getSession(int id);

	public List<Session> getAllSessions();

	public Session updateSession(Session change);

	public boolean deleteSession(int id);
}
