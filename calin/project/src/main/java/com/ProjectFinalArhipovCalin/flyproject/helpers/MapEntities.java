package com.ProjectFinalArhipovCalin.flyproject.helpers;

import com.ProjectFinalArhipovCalin.flyproject.models.entities.Fly;
import com.ProjectFinalArhipovCalin.flyproject.models.entities.User;
import com.ProjectFinalArhipovCalin.flyproject.models.FlyRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.FlyResponse;
import com.ProjectFinalArhipovCalin.flyproject.models.UserRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.UserResponse;

public class MapEntities {
    //intoarcem dintrun UserRequest un User
    public static User mapUserRequestToUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        return user;
    }

    //intoarcem dintr-un User in User Response
    public static UserResponse mapUserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        return userResponse;
    }

    public static Fly mapFlyRequestToFly(FlyRequest flyRequest) {
        Fly fly = new Fly();
        fly.setDeparture(flyRequest.getDeparture());
        fly.setLanding(flyRequest.getLanding());
        fly.setDateOfDeparture(flyRequest.getDateOfDeparture());
        fly.setReturnDate(flyRequest.getReturnDate());
        fly.setPassengers(flyRequest.getPassengers());
        return fly;
    }
    public static FlyResponse mapFlyToFlyResponse(Fly fly) {
        FlyResponse flyResponse = new FlyResponse();
        flyResponse.setId(fly.getId());
        flyResponse.setDeparture(fly.getDeparture());
        flyResponse.setLanding(fly.getLanding());
        flyResponse.setDateOfDeparture(fly.getDateOfDeparture());
        flyResponse.setReturnDate(fly.getReturnDate());
        flyResponse.setPassengers(fly.getPassengers());
        return flyResponse;
    }
    public static Fly mapFlyResponseToFly(FlyResponse flyResponse){
        Fly fly = new Fly();
        fly.setId(flyResponse.getId());
        fly.setDeparture(flyResponse.getDeparture());
        fly.setLanding(flyResponse.getLanding());
        fly.setDateOfDeparture(flyResponse.getDateOfDeparture());
        fly.setReturnDate(flyResponse.getReturnDate());
        fly.setPassengers(flyResponse.getPassengers());
        return fly;
    }

    public static User mapUserResponseToUser(UserResponse userResponse){
        User user = new User();
        user.setId(userResponse.getId());
        user.setEmail(userResponse.getEmail());
        user.setFirstName(userResponse.getFirstName());
        user.setLastName(userResponse.getLastName());
//        user.setFlights(userResponse.getFlights());
        return user;
    }
}
