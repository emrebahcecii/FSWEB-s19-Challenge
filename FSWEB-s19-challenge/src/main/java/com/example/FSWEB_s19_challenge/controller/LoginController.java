package com.example.FSWEB_s19_challenge.controller;

import com.example.FSWEB_s19_challenge.dto.LoginRequestDto;
import com.example.FSWEB_s19_challenge.entity.AppUser;
import com.example.FSWEB_s19_challenge.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping()
    public AppUser login(@RequestBody LoginRequestDto loginRequestDto){
        UserDetails userDetails = loginService.loadUserByUsername(loginRequestDto.email());

        if(userDetails instanceof AppUser appUser){
            return appUser;
        } else {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }
    }

}
