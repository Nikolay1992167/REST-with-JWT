package by.it.restjwt.service.impl;

import by.it.restjwt.entity.User;
import by.it.restjwt.repository.UserRepository;
import by.it.restjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found!"));
    }
}
