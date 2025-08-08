package com.project.basic_rest_api.service;

import java.util.List;
import java.util.UUID;

import com.project.basic_rest_api.exception.BadRequestException;
import com.project.basic_rest_api.exception.ConflictException;
import com.project.basic_rest_api.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.basic_rest_api.entity.User;
import com.project.basic_rest_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {
    

    @Autowired
    UserRepository userRepo;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    public User save(User user)  {

        if(user.getName() == null || user.getName().trim().isEmpty())
            throw new BadRequestException(("Name cannot be Empty or Null!"));

        if (!isEmailValid(user.getEmail()))
            throw new BadRequestException("Email is not valid");

        if(isEmailUsed(user.getEmail()))
            throw new ConflictException("This mail is already used !");

        user.setId(UUID.randomUUID());
        return userRepo.save(user);
    }

    public List<User> findAll (){

        return userRepo.findAll();
    }

    public User findById(String idString){
        UUID id;
        System.out.println("Received ID: '" + idString + "'");
        try {
             id = UUID.fromString(idString);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Wrong UUID format !!");
        }

        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("Could not find User !"));
    }

    public User updateUser(User updatedUser, String idString){

        UUID id = UUID.fromString(idString);
        User existingUser = userRepo.findById(id).orElse(null);

        if(existingUser == null)
            throw new NotFoundException("User does not exists!");

        if ( updatedUser.getName() == null ||updatedUser.getName().isEmpty())
            throw new BadRequestException("Name cannot be Empty !");
        
        if (updatedUser.getEmail() == null || !isEmailValid(updatedUser.getEmail()))
            throw new BadRequestException("Invalid Email");

        if(isEmailUsed(updatedUser.getEmail()))
            throw new ConflictException("Email is already used");

        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setName(updatedUser.getName());

        userRepo.save(existingUser);
        return existingUser;
          
    }

    public void deleteUser(String idString){

        UUID id = UUID.fromString(idString);
        userRepo.delete(id);

    }

    boolean isEmailValid(String email){
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    boolean isEmailUsed(String email){
        
        for (User u : userRepo.findAll()){
            if (u.getEmail().equalsIgnoreCase(email))
                return true;
        }
        return false;
    }
}
