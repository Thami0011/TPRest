package ma.emsi.tprest.controller;

import ma.emsi.tprest.model.User;
import ma.emsi.tprest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{p}")
    public User getUser(@PathVariable("p") Integer id){
        User user = userService.getUser(id);
        if(user!=null){
            return user;
        }
        return null;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/add")
    public String addUtilisateur(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/update/{p}")
    public String updateUser(@PathVariable("p") int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/supp")
    public void SupprimerUser(@RequestParam Integer id){
        userService.suppUser(id);
    }
}
