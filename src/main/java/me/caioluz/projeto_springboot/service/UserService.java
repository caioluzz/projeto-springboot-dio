package me.caioluz.projeto_springboot.service;

import me.caioluz.projeto_springboot.domain.modal.Account;
import me.caioluz.projeto_springboot.domain.modal.User;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService  {

    User findUserById(Long id);

    User createUser(User userToCreate);

    User updateUser(Long id, User updatedUser);

    User deleteUser(Long id);

    //Account findAccountById(Long Id);


}
