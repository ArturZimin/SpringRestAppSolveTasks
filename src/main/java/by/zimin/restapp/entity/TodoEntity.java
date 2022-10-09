package by.zimin.restapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@Getter
@Setter
@NoArgsConstructor
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//автоинкремент
    private Long id;
    private String title;
    private Boolean completed;
    private String description;

    @ManyToOne    //много задач у одного пользователя связъ
    @JoinColumn(name = "user_id")  //Foreign key on user_id каждый туду будет ссылаться на юзера айди
    private UserEntity user;


}
