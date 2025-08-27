package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.entity.AppUser;
import com.example.FSWEB_s19_challenge.entity.Role;
import com.example.FSWEB_s19_challenge.entity.User;
import com.example.FSWEB_s19_challenge.repository.AppUserRepository;
import com.example.FSWEB_s19_challenge.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegisterService {
    private AppUserRepository appUserRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder encoderPassword;

    @Autowired
    public RegisterService(AppUserRepository appUserRepository, RoleRepository roleRepository, PasswordEncoder encoderPassword) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
        this.encoderPassword = encoderPassword;
    }

    public AppUser register(String fullName, String email, String password){
        String encodPassword = encoderPassword.encode(password);
        Role role = roleRepository.findByAuthority("USER").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        AppUser appUser = new AppUser();
        appUser.setFullName(fullName);
        appUser.setEmail(email);
        appUser.setPassword(encodPassword);
        appUser.setAuthorities(roles);

        return appUserRepository.save(appUser);
    }
}
