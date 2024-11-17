package com.puneeth.EcomApp.repo;

import com.puneeth.EcomApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUserName(String userName);
}
