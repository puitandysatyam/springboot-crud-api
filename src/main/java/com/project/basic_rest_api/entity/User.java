package com.project.basic_rest_api.entity;

import java.util.UUID;

public class User {
    
    private UUID id;
    private String name , email;

    //getters

    public String getName (){
        return name;
    }

    public String getEmail (){
        return email;
    }
    
    public UUID getId(){
        return id;
    }

    //setters

    public void setName(String name){
        this.name = name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public void setId(UUID id){
        this.id = id;
    }
    
}
