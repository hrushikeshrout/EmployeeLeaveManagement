package com.project.employeeleavemanagement.mapper;

import com.project.employeeleavemanagement.dto.UserDTO;
import com.project.employeeleavemanagement.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsersMapper {
    public static UserDTO toDTO(Users users){

            if (users != null){
                return new UserDTO(users.getId(),users.getUserName(),users.getPassword());
            }
            return null;


    }
}
