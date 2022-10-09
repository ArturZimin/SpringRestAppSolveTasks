package by.zimin.restapp.service;

import by.zimin.restapp.entity.UserEntity;
import by.zimin.restapp.exception.UserAlreadyExistException;
import by.zimin.restapp.exception.UserNotFoundException;
import by.zimin.restapp.model.Todo;
import by.zimin.restapp.model.User;
import by.zimin.restapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


//    public UserEntity updateUser(Long id,UserEntity user) throws UserNotFoundException {
//       UserEntity userEntity = userRepository.findById(id).get();
//        if (userEntity == null) {
//            throw new UserNotFoundException("The user was not found!");
//        }
//        userRepository.setUsername(user.getUsername());
//        userEntity.setPassword(user.getPassword());
//        userEntity.setListTasks(user.getListTasks().stream().map(Todo::toTodoU).collect(Collectors.toList()));
//        return userRepository.save(userRepository.findById(id).get());
//    }

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()) != null) { //findByUsername обязательно такое название
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует!");
        }
        return userRepository.save(user);

    }


    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("The user was not found!");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) throws UserNotFoundException {
        userRepository.deleteById(id);
        return id;
    }
}
