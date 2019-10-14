package com.tavisca.gce.AuthenticationApi.controllers;

import com.tavisca.gce.AuthenticationApi.model.User;
import com.tavisca.gce.AuthenticationApi.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.sql.Date;

@RestController
@EnableAutoConfiguration
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;


    //List<User> listOfUsers = new ArrayList<>();
    Map<String, String> usernamePasswordMap = new HashMap<>();

    @GetMapping(path = "/")
    public String home() {
        return ("<h1>Welcome Monday</h1>");
    }

    @PostMapping(path = "/user")
    public String createUser(@RequestBody String json ){
        JSONObject jsonObject = new JSONObject(json);
        User user = new User();
        //user.setEid((int)userRepository.count());
        user.setName(jsonObject.getString("name"));
        user.setCompany(jsonObject.getString("company"));
        user.setDob((Date.valueOf(jsonObject.getString("dob"))));
        user.setDoj(Date.valueOf(jsonObject.getString("doj")));
        user.setCreatedBy(jsonObject.getString("createdBy"));
        user.setCreationDate(Date.valueOf(jsonObject.getString("creationDate")));
        user.setCreatedBy("Admin: 1");
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        user.setUsername(username);
        user.setPassword(password);
        usernamePasswordMap.put(username, password);
        userRepository.save(user);
        return "user added";
    }

    @GetMapping(path = "/user")
    public List<User> getUserDetails(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/user/{id}")
    public Optional<User> getUserDetailsById(@PathVariable("id") int eid){
        return userRepository.findById(eid);
    }

    @PostMapping(path = "/login")
    public String validateUser(@RequestBody String json){
        JSONObject jsonObject = new JSONObject(json);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        for(int i =0; i < usernamePasswordMap.size(); i++){
            if( usernamePasswordMap.containsKey(username) && (usernamePasswordMap.get(username).equals(password)) ){
                System.out.println(username + " is successfully logged in");
                return (username + " is successfully logged in");
            }
        }
        System.out.println( username +"'s username or password is wrong.!!!");
        return ( username +"'s username or password is wrong.!!!");
    }

    @PatchMapping(path = "update")
    public String updateDetails(@RequestBody String json){
        JSONObject jsonObject = new JSONObject(json);
        String eid = jsonObject.getString("eid");
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        for(int i =0; i < userRepository.count(); i++){
            if( usernamePasswordMap.containsKey(username) && (usernamePasswordMap.get(username).equals(password)) ){
                System.out.println(username + " is successfully logged in");
                return (username + " is successfully logged in");
            }
        }
        System.out.println(username + "'s username or password is wrong.!!!");
        return (username + "'s username or password is wrong.!!!");
    }
}
