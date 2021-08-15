package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.Session;
import com.revature.repositories.SessionRepo;

@Service
@Qualifier("SessionService")
public class SessionServiceImpl implements SessionService {

    private static final Logger log = Logger
            .getLogger(SessionServiceImpl.class);
    
	@Autowired
	SessionRepo sr;

	@Override
	public Session addSession(Session s) {
		return sr.save(s);
	}

	@Override
	public Session getSession(int id) {
	    Optional<Session> opS = sr.findById(id);
        if (opS.isPresent()) {
            return opS.get();
        } else {
            return null;
        }
	}

	@Override
	public List<Session> getAllSessions() {
		return (List<Session>) sr.findAll();
	}

	@Override
	public Session updateSession(Session change) {
	    if (sr.existsById(change.getId())) {
            return sr.save(change);
        } else {
            return null;
        }
	}

	@Override
	public boolean deleteSession(int id) {
		try {
			sr.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			log.warn(e);;
			return false;
		}
	}

}
