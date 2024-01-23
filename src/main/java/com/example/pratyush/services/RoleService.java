package com.example.pratyush.services;

import com.example.pratyush.entity.Role;
import com.example.pratyush.repo.RoleRepo;
import com.example.pratyush.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    UserRepo urepo;

    @Autowired
    RoleRepo rrepo;

    public void addRole(Role role){
        rrepo.save(role);
    }

    public Role getRole(Long rid){
        return rrepo.findById(rid).orElse(null);
    }

    public Role putRole(Long rid,Role role){
        if(rrepo.existsById(rid)){
            role.setRole_id(rid);
            return rrepo.save(role);
        }else{
            return null;
        }
    }

//    public Set<User> getUsers(Long rid,Long uid){
//        Role role=rrepo.findById(rid).orElse(null);
//
//        User user=urepo.findById(uid).orElse(null);
//
//        assert user != null;
//        Set<Role> roleSet=user.getAssignedRoles().isEmpty()?null:user.getAssignedRoles();
//        assert role != null;
//        Set<User> userSet=role.getAssignedUsers().isEmpty()?null:role.getAssignedUsers();
//
//        System.out.println(roleSet);
//
//        return userSet;
//    }
}
