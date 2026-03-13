package com.Qauser.Quaser.Controller;


import com.Qauser.Quaser.Entity.UserPerson;
import com.Qauser.Quaser.Service.UserPersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userPeople")
public class UserPersonController {

    private final UserPersonService userService;

    public UserPersonController(UserPersonService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserPerson registerUser(@RequestParam UserPerson user){
        return userService.registerUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(Long id){
        userService.deleteById(id);
    }

    @PostMapping("/login")
    public UserPerson login(@RequestBody UserPerson user){
        return userService.login(user.getUsername(), user.getPassword());
    }
}
