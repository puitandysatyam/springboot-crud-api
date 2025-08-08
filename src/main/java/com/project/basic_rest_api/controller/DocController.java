package com.project.basic_rest_api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.project.basic_rest_api.entity.User;
import com.project.basic_rest_api.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class DocController {

    @Autowired
    UserService userService;
    
//create
@PostMapping("/save")
public ResponseEntity<User> createUser(@RequestBody User user ){
   User createdUser = userService.save(user);
   return ResponseEntity.status(201).body(createdUser);
}

//read

@GetMapping("/view/{id}")
public ResponseEntity<User> viewUserById(@PathVariable String id){

    return ResponseEntity.ok(userService.findById(id));

}

@GetMapping("/view")
public ResponseEntity<List<User>> viewAll (){
    return ResponseEntity.ok(userService.findAll());
}


//update

@PutMapping("/update/{id}")
public ResponseEntity<User> updateUser(@RequestBody User updatedUser, @PathVariable String id){
    return ResponseEntity.ok(userService.updateUser(updatedUser, id));
}


//delete

@DeleteMapping("/delete/{id}")
public ResponseEntity<Void> deleteUser (@PathVariable String id){

    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
    
}
}
