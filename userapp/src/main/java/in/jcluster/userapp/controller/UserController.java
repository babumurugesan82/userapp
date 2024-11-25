package in.jcluster.userapp.controller;

import in.jcluster.userapp.entity.User;
import in.jcluster.userapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    //create a user rest api
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saveUSer=userService.createUser(user);
        return new ResponseEntity<User>(saveUSer, HttpStatus.CREATED);
    }

    //create rest api for getuserbyId
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user=userService.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //build res api to get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //build api to update a user
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        user.setId(userId);
        User updateUser=userService.updateUser(user);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    //build rest api to delete a user
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully Deleted", HttpStatus.OK);
    }
}
