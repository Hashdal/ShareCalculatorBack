package com.learning.content_calendar.service;

import org.springframework.stereotype.Service;
import com.learning.content_calendar.entity.User;
import com.learning.content_calendar.repository.UserRepository;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}