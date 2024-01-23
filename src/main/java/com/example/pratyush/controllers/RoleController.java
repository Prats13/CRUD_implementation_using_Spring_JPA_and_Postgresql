package com.example.pratyush.controllers;

import com.example.pratyush.entity.Role;
import com.example.pratyush.entity.User;
import com.example.pratyush.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/ims/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/addRole")
    public ResponseEntity<String> addRole(@RequestBody Role role){
        roleService.addRole(role);
        return ResponseEntity.ok("Role saved");
    }

    @GetMapping("/getRole/{rid}")
    public ResponseEntity<Role> getRole(@PathVariable Long rid){
        Role r=roleService.getRole(rid);
        return ResponseEntity.ok(r);
    }

    @PutMapping("/putRole/{rid}")
    public ResponseEntity<Role> putRole(@PathVariable Long rid,@RequestBody Role r){
        return ResponseEntity.ok(roleService.putRole(rid,r));
    }

//    @GetMapping("/{rid}/getUsers/{uid}")
//    public ResponseEntity<Set<User>> getUsers(@PathVariable Long rid,@PathVariable Long uid){
//        Set<User> result=roleService.getUsers(rid,uid);
//        if(result!=null){
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
