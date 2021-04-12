package org.rest.services;

import org.rest.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto addUser(UserDto userDto);
    String removeUser(Integer id);
}
