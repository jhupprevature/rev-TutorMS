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

import com.revature.beans.DateEvent;
import com.revature.services.DateEventService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DateEventController {

	@Autowired
	DateEventService des;

	@CrossOrigin
	@GetMapping(value = "/dateEvents", produces = "application/json")
	public List<DateEvent> getAllDateEvents() {
		return des.getAllDateEvents();
	}

	@CrossOrigin
	@GetMapping("dateEvents/{id}")
	public DateEvent getDateEvent(@PathVariable("id") String id) {
		return des.getDateEvent(Integer.parseInt(id));
	}

	@CrossOrigin
	@PostMapping(value = "/dateEvents", consumes = "application/json", produces = "application/json")
	public DateEvent addDateEvent(@RequestBody DateEvent de) {
		return des.addDateEvent(de);
	}

	@CrossOrigin
	@PutMapping(value = "/dateEvents/{id}", consumes = "application/json", produces = "application/json")
	public DateEvent updateDateEvent(@PathVariable String id, @RequestBody DateEvent change) {
		change.setId(Integer.parseInt(id));
		return des.updateDateEvent(change);
	}

	@CrossOrigin
	@DeleteMapping("dateEvents/{id}")
	public boolean deleteDateEvent(@PathVariable("id") String id) {
		return des.deleteDateEvent(Integer.parseInt(id));
	}
}
