package edu.zubkov.crudapp.services;

import edu.zubkov.crudapp.models.User;
import edu.zubkov.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void add(UserDto userDto);

    void deleteById(long id);

    void update(UserDto userDto, long id);

    User getById(long id);

    List<User> getAllUsers();

    User findByUsername(String username);
}