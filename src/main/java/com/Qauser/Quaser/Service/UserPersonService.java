package com.Qauser.Quaser.Service;

import com.Qauser.Quaser.Entity.UserPerson;
import com.Qauser.Quaser.Repository.UserPersonRepo;
import org.springframework.stereotype.Service;

@Service
public class UserPersonService {

    private final UserPersonRepo userRepo;

    public UserPersonService(UserPersonRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserPerson registerUser(UserPerson user){
        if(user.getRole() == null){
            user.setRole("USER");
        }
        return userRepo.save(user);
    }

    public void deleteById(Long id){
        userRepo.deleteById(id);
    }

    public UserPerson login(String username, String password) {
        UserPerson user = userRepo.findByUsername(username);

        if(user == null){
            throw new RuntimeException("User Not Found!");
        }
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid Password");
        }
        return user;
    }
}
