package com.example.FSWEB_s19_challenge.service;

import com.example.FSWEB_s19_challenge.repository.AppUserRepository;
import com.example.FSWEB_s19_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    private AppUserRepository appUserRepository;

    @Autowired
    public LoginService(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findUserByEmail(username)
                .orElseThrow(() -> {
                    System.out.println("Kullanıcı bulunamadı! ");
                    throw new UsernameNotFoundException("Kullanıcı bulunamadı! ");
                });
    }

}
