package com.UserAplication.repository;

import com.UserAplication.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDetails,Integer> {

    

    @Query("SELECT u FROM UserDetails u WHERE u.name LIKE %?1%")
    public List<UserDetails> findAllByName(String keyword);
}
