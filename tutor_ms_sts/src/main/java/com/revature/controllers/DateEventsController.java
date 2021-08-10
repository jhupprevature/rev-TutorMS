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

import com.revature.beans.DateEvents;
import com.revature.services.DateEventsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DateEventsController {

	@Autowired
	DateEventsService des;

	@CrossOrigin
	@GetMapping(value = "/dateEvents", produces = "application/json")
	public List<DateEvents> getAllDateEvents() {
		return des.getAllDateEvents();
	}

	@CrossOrigin
	@GetMapping("dateEvents/{id}")
	public DateEvents getDateEvents(@PathVariable("id") String id) {
		return des.getDateEvents(Integer.parseInt(id));
	}

	@CrossOrigin
	@PostMapping(value = "/dateEvents", consumes = "application/json", produces = "application/json")
	public DateEvents addDateEvents(@RequestBody DateEvents de) {
		return des.addDateEvents(de);
	}

	@CrossOrigin
	@PutMapping(value = "/dateEvents/{id}", consumes = "application/json", produces = "application/json")
	public DateEvents updateDateEvents(@PathVariable int id, @RequestBody DateEvents change) {
		change.setId(id);
		return des.updateDateEvents(change);
	}

	@CrossOrigin
	@DeleteMapping("dateEvents/{id}")
	public boolean deleteDateEvents(@PathVariable("id") String id) {
		return des.deleteDateEvents(Integer.parseInt(id));
	}
}
