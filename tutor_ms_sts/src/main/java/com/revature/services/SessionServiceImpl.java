package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.Session;
import com.revature.repositories.SessionRepo;

@Service
@Qualifier("SessionService")
public class SessionServiceImpl implements SessionService {

	@Autowired
	SessionRepo sr;

	@Override
	public Session addSession(Session s) {
		return sr.save(s);
	}

	@Override
	public Session getSession(int id) {
		return sr.findById(id).get();
	}

	@Override
	public List<Session> getAllSessions() {
		return (List<Session>) sr.findAll();
	}

	@Override
	public Session updateSession(Session change) {
		return sr.save(change);
	}

	@Override
	public boolean deleteSession(int id) {
		try {
			sr.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
