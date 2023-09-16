package by.it.restjwt.service;

import by.it.restjwt.dto.UserDto;

import java.util.List;

public interface AdminService {

    void setAdmin(Long id);

    List<UserDto> getAllUsers();
}
