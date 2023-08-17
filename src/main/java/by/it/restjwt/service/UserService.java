package by.it.restjwt.service;

import by.it.restjwt.entity.User;

public interface UserService {

    User getUserByUsername(String username);
}
