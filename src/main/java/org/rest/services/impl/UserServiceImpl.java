package org.rest.services.impl;


import org.modelmapper.ModelMapper;
import org.rest.entity.User;
import org.rest.entity.dto.FruitDto;
import org.rest.entity.dto.UserDto;
import org.rest.repository.UserRepository;
import org.rest.services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    UserRepository userRepository;

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();
        List<UserDto> userDtos = new ArrayList<>();
        for(User user: users){
            userDtos.add(modelMapper.map(user, UserDto.class));
        }
        return userDtos;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        user = userRepository.add(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public String removeUser(Integer id) {

        userRepository.userDelete(id);
        return "User deleted";
    }
}
