package com.example.pratyush.repo;

import com.example.pratyush.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepo extends JpaRepository<Role,Long> {

}
