package me.caioluz.projeto_springboot.service.impl;

import jakarta.persistence.EntityNotFoundException;
import me.caioluz.projeto_springboot.domain.modal.User;
import me.caioluz.projeto_springboot.domain.repository.UserRepository;
import me.caioluz.projeto_springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User with id " + id + " does not exist"));
    }

    @Override
    public User createUser(User userToCreate) {
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("User with id " + userToCreate.getId() + " already exists");
        }
        return this.userRepository.save(userToCreate);
    }

    @Override
    public User updateUser(Long id, User userUpdated) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(userUpdated.getName());
                    existingUser.setCpf(userUpdated.getCpf());
                    existingUser.setEndereco(userUpdated.getEndereco());

                    return userRepository.save(existingUser);
                }).orElseThrow(() -> new NoSuchElementException("User with id " + id + " does not exist"));

    }

    @Override
    public User deleteUser(Long id) {
        return userRepository.findById(id)
                .map(user -> {userRepository.delete(user); return user;})
                .orElseThrow(() -> new NoSuchElementException("User with id " + id + " does not exist"));
    }
}
