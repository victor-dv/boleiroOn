package br.com.boleiroOn.domain.user.repository;

import br.com.boleiroOn.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByLogin(String login);
    boolean existsByEmail(String email);
}
