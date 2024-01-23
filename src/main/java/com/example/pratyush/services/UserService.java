package com.example.pratyush.services;

import com.example.pratyush.entity.Role;
import com.example.pratyush.repo.RoleRepo;
import com.example.pratyush.repo.UserRepo;
import com.example.pratyush.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    UserRepo urepo;

    @Autowired
    RoleRepo rrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(User user){
        //Encoding password
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        urepo.save(user);
    }

    public User getUser(Long uid){
        return urepo.findById(uid).orElse(null);
    }

    public User putUser(Long uid,User user){
        if(urepo.existsById(uid)){
            user.setUser_id(uid);
            return urepo.save(user);
        }else{
            return null;
        }
    }

    public User addRoletoUser(Long uid,Long rid){
        Role role = rrepo.findById(rid).get();
        User user = urepo.findById(uid).get();
        user.getAssignedRoles().add(role);
        return urepo.save(user);
    }

    public String changePassword(Long uid,List<String> pass){
        User u=urepo.findById(uid).orElse(null);
        if(u!=null){
            if(this.passwordEncoder.matches(pass.get(0),u.getPassword())){
                u.setPassword(this.passwordEncoder.encode(pass.get(1)));
                urepo.save(u);
                return "Password changed successfully!!";
            }else{
                return "Error: Password mismacth";
            }
        }else{
            return "Error in finding user!";
        }
    }

}
