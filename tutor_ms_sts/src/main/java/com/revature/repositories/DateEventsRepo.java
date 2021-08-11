package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.DateEvent;

@Repository
public interface DateEventsRepo extends CrudRepository<DateEvent, Integer> {

}
