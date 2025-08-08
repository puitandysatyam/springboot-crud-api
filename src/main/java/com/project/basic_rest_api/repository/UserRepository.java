package com.project.basic_rest_api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.project.basic_rest_api.entity.User;

@Repository
public class UserRepository {
    
    private static final Map<UUID,User> userStore = new HashMap<>();


    public List<User> findAll(){
        return new ArrayList<>(userStore.values());
    } 

    public Optional<User> findById(UUID id){

        return Optional.ofNullable(userStore.get(id));  
    }

    public User save(User user){
        userStore.put(user.getId(),user);
        return user;
        
    }

    public void delete(UUID id){
        userStore.remove(id);
    }
}
