package com.ProjectFinalArhipovCalin.flyproject.Service.users;

import com.ProjectFinalArhipovCalin.flyproject.models.entities.User;
import com.ProjectFinalArhipovCalin.flyproject.models.UserRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.UserResponse;

import java.util.List;

//aceasta clasa poate fi injectata ca o dependinta, asta face @Service
//@Component //poate fi injectat mai departe
//1. tre sa avem save, create, delete, update

public interface UsersService {

    UserResponse createUser(UserRequest userRequest);

    void deleteUser(Integer id);  //diferentiez User-ul dupa id prin parametru

    void deleteAll();

    List<UserResponse> findAll();

    UserResponse findById(Integer id);

    UserResponse updateUser(Integer id, UserRequest userRequest);

    UserResponse updateFlights(User user);
}
