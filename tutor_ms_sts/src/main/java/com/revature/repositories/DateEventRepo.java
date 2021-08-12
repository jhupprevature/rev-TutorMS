package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.DateEvent;

@Repository
public interface DateEventRepo extends CrudRepository<DateEvent, Integer> {

}
