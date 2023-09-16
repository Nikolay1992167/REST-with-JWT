package by.it.restjwt.service;

import by.it.restjwt.dto.UserDto;
import by.it.restjwt.dto.UserRegistrationDto;
import by.it.restjwt.entity.User;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    void save(UserRegistrationDto userRegistrationDto);

    boolean isUserExist(String username);

    void setRoleAdmin(Long id);

    List <UserDto> getAllUsers();
}
