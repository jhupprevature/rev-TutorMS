package com.revature.services;

import java.util.List;

import com.revature.beans.Analytic;
import com.revature.beans.JsonRequestSession;
import com.revature.beans.Session;

public interface SessionService {

	public Session addSession(JsonRequestSession jrs);

	public Session getSession(int id);

	public List<Session> getAllSessions();

	public Session updateSession(Session change);

	public boolean deleteSession(int id);

    public Analytic getAnalytic();
}
