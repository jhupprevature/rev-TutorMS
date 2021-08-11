package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Session;

@Repository
public interface SessionRepo extends CrudRepository<Session, Integer> {

}
