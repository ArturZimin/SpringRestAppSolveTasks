package by.zimin.restapp.model;


import by.zimin.restapp.entity.TodoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }


    public static TodoEntity  toTodoEntity(Todo todo) {
        TodoEntity todoEntity=new TodoEntity();
        todoEntity.setId(todo.getId());
        todoEntity.setTitle(todo.getTitle());
        todoEntity.setCompleted(todo.getCompleted());

       return todoEntity;
    }
}