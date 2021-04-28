package com.UserAplication.service;

import com.UserAplication.model.UserDetails;
import com.UserAplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

   public void addUser(UserDetails userDetails){
       this.userRepository.save(userDetails);
   }

    public List<UserDetails> getAllUsers(){
         return (List<UserDetails>) this.userRepository.findAll();
    }

    public void deleteUser(Integer id){
       this.userRepository.deleteById(id);
    }

    public Optional<UserDetails> getUserByID(Integer id){
       return this.userRepository.findById(id);
    }

    public List<UserDetails> findByUserName(String name){
        return this.userRepository.findAllByName(name);
    }


}
