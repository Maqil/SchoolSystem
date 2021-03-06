package com.school.repository;

import com.school.entities.Role;
import com.school.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query("select r from Role r where r.name like :roleName")
    Role findByRoleName(RoleName roleName);

}
