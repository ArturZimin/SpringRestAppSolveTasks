package by.zimin.restapp.service;

import by.zimin.restapp.entity.TodoEntity;
import by.zimin.restapp.entity.UserEntity;
import by.zimin.restapp.model.Todo;
import by.zimin.restapp.repository.TodoRepository;
import by.zimin.restapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepo;
    @Autowired
    private UserRepository userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return by.zimin.restapp.model.Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return by.zimin.restapp.model.Todo.toModel(todoRepo.save(todo));
    }
}
