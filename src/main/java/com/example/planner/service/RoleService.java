package com.example.planner.service;

import com.example.planner.model.Role;
import com.example.planner.model.Customer;
import com.example.planner.repository.RoleRepo;
import com.example.planner.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {
    private final CustomerRepo customerRepo;
    private final RoleRepo roleRepo;

    public Customer createUserWithRole(Customer user, Role role) {
        Role newRole = roleRepo.save(role);
        user.setRole(newRole);
        return customerRepo.save(user);
    }

    public String saveRoleToUser(String email, String roleName) {
        Customer user = customerRepo.findUserByEmail(email);
        log.info(email);
        log.info(String.valueOf(user));
        if (user == null) {
            log.info("null user");
            return "user does not exixt";
        }
        Role role = roleRepo.findRoleByRoleName(roleName);
        user.setRole(role);
        customerRepo.save(user);
        return "role saved to user successfully";
    }

    public Role saveRole(Role role) {
        Role initialRole = roleRepo.findRoleByRoleName(role.getRoleName());
        if (initialRole != null) {
            return initialRole;
        }
        Role role1 = roleRepo.save(role);
        return role1;
    }
}
