package com.example.FSWEB_s19_challenge.controller;

import com.example.FSWEB_s19_challenge.dto.AppUserRequestDto;
import com.example.FSWEB_s19_challenge.entity.AppUser;
import com.example.FSWEB_s19_challenge.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public AppUser register(@RequestBody AppUserRequestDto appUserRequestDto){
        return registerService
                .register(appUserRequestDto.fullName(),appUserRequestDto.email(),appUserRequestDto.password());
    }

}
