package com.example.FSWEB_s19_challenge.mapper;

import com.example.FSWEB_s19_challenge.dto.UserPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.UserRequestDto;
import com.example.FSWEB_s19_challenge.dto.UserResponseDto;
import com.example.FSWEB_s19_challenge.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDto userRequestDto){
        User user = new User();
        user.setUserName(userRequestDto.userName());
        user.setEmail(userRequestDto.email());
        return user;
    }

    public UserResponseDto toResponseDto(User user){
        return new UserResponseDto(user.getUserName(), user.getEmail());
    }

    public User updateEntity(User userToUpdate, UserPatchRequestDto userPatchRequestDto){
        if(userPatchRequestDto.userName() != null){
            userToUpdate.setUserName(userPatchRequestDto.userName());
        }
        if(userPatchRequestDto.email() != null){
            userToUpdate.setEmail(userPatchRequestDto.email());
        }
        return userToUpdate;
    }
}
