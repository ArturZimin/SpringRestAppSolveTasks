package by.zimin.restapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")//у одного пользователя может быть много задач ,а также если мы удаляем пользователя то и удаляются все задачи
    private List<TodoEntity> listTasks;                //mappedBy- чтобы связать наши сущности (двунаправленная связь)
}
