package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.JsonRequestSession;
import com.revature.beans.Session;
import com.revature.services.SessionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SessionController {

	@Autowired
	SessionService ss;

	@CrossOrigin
	@GetMapping(value = "/Sessions", produces = "application/json")
	public List<Session> getAllSessions() {
		return ss.getAllSessions();
	}

	@CrossOrigin
	@GetMapping("Sessions/{id}")
	public Session getSession(@PathVariable("id") String id) {
		return ss.getSession(Integer.parseInt(id));
	}

	@CrossOrigin
	@PostMapping(value = "/Sessions", consumes = "application/json", produces = "application/json")
	public Session addSession(@RequestBody JsonRequestSession jrs) {
		return ss.addSession(jrs);
	}

	@CrossOrigin
	@PutMapping(value = "/Sessions/{id}", consumes = "application/json", produces = "application/json")
	public Session updateSession(@PathVariable int id, @RequestBody Session change) {
		change.setId(id);
		return ss.updateSession(change);
	}

	@CrossOrigin
	@DeleteMapping("Sessions/{id}")
	public boolean deleteSession(@PathVariable("id") String id) {
		return ss.deleteSession(Integer.parseInt(id));
	}
	
}
