package com.ProjectFinalArhipovCalin.flyproject.controllers;

import com.ProjectFinalArhipovCalin.flyproject.Service.fly.FlightsService;
import com.ProjectFinalArhipovCalin.flyproject.Service.users.UsersService;
import com.ProjectFinalArhipovCalin.flyproject.models.entities.Fly;
import com.ProjectFinalArhipovCalin.flyproject.models.entities.User;
import com.ProjectFinalArhipovCalin.flyproject.helpers.MapEntities;
import com.ProjectFinalArhipovCalin.flyproject.models.FlyResponse;
import com.ProjectFinalArhipovCalin.flyproject.models.UserRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.UserResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
//http://localhost:8081/v1/users (e un endpoin care in spate face un get )

@Getter
@Setter
@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("http://localhost:4200/ ")
public class UsersController {

    private final UsersService usersService;
    private final FlightsService flightsService;

    public UsersController(UsersService usersService, FlightsService flightsService) {
        this.usersService = usersService;
        this.flightsService = flightsService;
    }


    //Jpa vine cu toate metodele de CRUD
    //1.luam toti userii din baza //returneaza un userResponse primeste un userRequest
    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        try {
            return new ResponseEntity<>(usersService.createUser(userRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //2.Sterge user-ul dupa id.
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Integer id) {
        usersService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //3.Sterge toti userii
    @DeleteMapping("/deleteAll")
    public ResponseEntity<User> deleteAllUsers() {
        usersService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //4:Ne da o lista de useri din usersRepository(pe toti).
    @GetMapping()
    public ResponseEntity<List<UserResponse>> getUsers() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    //5: Vom lua un user dupa id
    @GetMapping("/{id}") //{id} e o variabila dinamica
    public ResponseEntity<UserResponse> getUsersById(@PathVariable Integer id) { //Optional lucreaza cu stremuri
        UserResponse foundUser = usersService.findById(id); //stocam intr-o variabila
        if (foundUser != null) {                            //daca foundUser diferit de null adica l-am gasit ...
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    //6.update
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> updateUsers(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        UserResponse updatedUser = usersService.updateUser(id, userRequest);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);

        }
    }

    @PostMapping("/{userId}/addFly/{flyId}")
    public ResponseEntity<UserResponse> addFly(@PathVariable Integer userId, @PathVariable Integer flyId) {
        FlyResponse flyResponse = this.flightsService.findById(flyId);
        UserResponse userResponse = this.usersService.findById(userId);
        if (flyResponse == null || userResponse == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Fly fly = MapEntities.mapFlyResponseToFly(flyResponse);
        User user = MapEntities.mapUserResponseToUser(userResponse);
        //Adaugam un fly la o lista de fly
//        List<Fly> flights = user.getFlights();//iau lista veche

//        var foundFly = flights.stream().filter(f -> f.getId().equals(flyId)).toList(); //ilustrez toate elementele pina cind dau de unul care se repeta(nu vrem sa facem dublicate)
//        if(!foundFly.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        flights.add(fly);                     //adaug lista noua la lista veche
//        user.setFlights(flights);             //setez lista veche cu lista noua
        return new ResponseEntity<>(this.usersService.updateFlights(user),HttpStatus.OK);


    }
}