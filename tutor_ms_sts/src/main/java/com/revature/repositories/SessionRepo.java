package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Session;

@Repository
public interface SessionRepo extends JpaRepository<Session, Integer> {

    List<Session> findAllByOrderByStartTimeDesc();

}
