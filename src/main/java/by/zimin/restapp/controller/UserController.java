package by.zimin.restapp.controller;

import by.zimin.restapp.entity.UserEntity;
import by.zimin.restapp.exception.UserAlreadyExistException;
import by.zimin.restapp.exception.UserNotFoundException;
import by.zimin.restapp.model.User;
import by.zimin.restapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") //address in browser http://localhost:8080/users
public class UserController {

    @Autowired//спринг сюда подставит экземпляр класса (инъекция)
    private UserService userService;


    //метод для сохранения
    @PostMapping//что-то добавляем
    public ResponseEntity registration(@RequestBody UserEntity user){ //request in body (create new user)
        try{
           userService.registration(user);
            return ResponseEntity.ok("The user was save successfully");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }


    //получение юзеров
    @GetMapping                                            //получение данных(GET)
    public ResponseEntity getOneUser(@RequestParam Long id){ //query param-это то что после вопросительного знака-> ?id=1
        try{
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }

    @DeleteMapping("/{id}")                               //delete by id  http://localhost:8080/users/{1}
    public ResponseEntity deleteUser(@PathVariable long id){//переменная пути
        try{
            return ResponseEntity.ok(userService.delete(id));

        }catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong!");
        }
    }

//    @PutMapping("/users/{id}")                                        //update user by id 
//    public ResponseEntity<User> updateUser(@PathVariable (value = "id") Long userId,@RequestBody UserEntity userDetails) throws ResourceNotFoundException{
//        try{
//
//            return ResponseEntity.ok(userService.updateUser(userId,userDetails));
//
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Something went wrong!");
//        }
//    }


}
