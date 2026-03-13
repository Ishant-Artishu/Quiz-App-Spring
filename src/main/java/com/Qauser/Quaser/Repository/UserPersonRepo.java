package com.Qauser.Quaser.Repository;

import com.Qauser.Quaser.Entity.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersonRepo extends JpaRepository<UserPerson, Long> {
    UserPerson findByUsername(String username);
}
