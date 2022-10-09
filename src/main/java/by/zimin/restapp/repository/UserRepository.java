package by.zimin.restapp.repository;

import by.zimin.restapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    UserEntity findByUsername(String username);


}
