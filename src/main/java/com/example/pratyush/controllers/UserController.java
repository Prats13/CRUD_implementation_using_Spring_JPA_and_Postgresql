package com.example.pratyush.controllers;

import com.example.pratyush.entity.Role;
import com.example.pratyush.entity.User;
import com.example.pratyush.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/ims/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok("User saved");
    }
    @GetMapping("/getUser/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable Long user_id){
        User u=userService.getUser(user_id);
        return ResponseEntity.ok(u);
    }

    @PutMapping("/putUSer/{uid}")
    public ResponseEntity<User> putUser(@PathVariable Long uid, @RequestBody User u){
        return ResponseEntity.ok(userService.putUser(uid,u));
    }

    @PutMapping("/{user_id}/assignRole/{role_id}")
    public ResponseEntity<User> addRoletoUser(
            @PathVariable Long user_id,
            @PathVariable Long role_id
    ) {
        User u=userService.addRoletoUser(user_id,role_id);
        return ResponseEntity.ok(u);
    }

    @PutMapping("/changePassword/{uid}")
    public ResponseEntity<String> changePassword(@PathVariable Long uid, @RequestBody List<String> pass){
        String result=userService.changePassword(uid,pass);
        return ResponseEntity.ok(result);
    }

}
