package com.learning.content_calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.content_calendar.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

}