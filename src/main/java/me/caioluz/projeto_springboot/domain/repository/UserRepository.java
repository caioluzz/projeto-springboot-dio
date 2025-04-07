package me.caioluz.projeto_springboot.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.caioluz.projeto_springboot.domain.modal.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
