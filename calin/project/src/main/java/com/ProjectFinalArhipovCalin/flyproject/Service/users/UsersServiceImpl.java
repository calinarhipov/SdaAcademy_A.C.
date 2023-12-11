package com.ProjectFinalArhipovCalin.flyproject.Service.users;

import com.ProjectFinalArhipovCalin.flyproject.models.entities.User;
import com.ProjectFinalArhipovCalin.flyproject.helpers.MapEntities;
import com.ProjectFinalArhipovCalin.flyproject.models.UserRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.UserResponse;
import com.ProjectFinalArhipovCalin.flyproject.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //aceasta clasa poate fi injectata ca o dependinta, asta face @Service
public class UsersServiceImpl implements UsersService {
    //avem nevoie pentru a vb cu UsersRepository
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = MapEntities.mapUserRequestToUser(userRequest);   //tre sa face un User dintr-un user reqest
        User newUser = this.usersRepository.save(user);
        return MapEntities.mapUserToUserResponse(newUser);
    }

    @Override
    public void deleteUser(Integer id) {
        this.usersRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.usersRepository.deleteAll();
    }

    @Override
    public List<UserResponse> findAll() {
        return this.usersRepository.findAll()
                .stream()
                .map(MapEntities::mapUserToUserResponse)
                .toList();
    }

    @Override
    public UserResponse findById(Integer id) {
        Optional<User> userFound = this.usersRepository.findById(id); //Optional lucreaza cu stremuri
        if (userFound.isPresent()) {
            User user = userFound.get();
            return MapEntities.mapUserToUserResponse(user);
        }
        return null;
    }

    @Override //transform din user in userResonse
    public UserResponse updateUser(Integer id, UserRequest userRequest) {
        Optional<User> userFound = this.usersRepository.findById(id);
        if (userFound.isPresent()) {
            User newUser = userFound.get();
            newUser.setEmail(userRequest.getFirstName());
            newUser.setFirstName(userRequest.getFirstName());
            newUser.setLastName(userRequest.getLastName());
            this.usersRepository.save(newUser);
            return MapEntities.mapUserToUserResponse(newUser);
        }
        return null;
    }

    @Override
    public UserResponse updateFlights(User user) {
        User savedUser = this.usersRepository.save(user);
        return MapEntities.mapUserToUserResponse(savedUser);
    }

}

