package com.ProjectFinalArhipovCalin.flyproject.controllers;

import com.ProjectFinalArhipovCalin.flyproject.Service.fly.FlightsService;
import com.ProjectFinalArhipovCalin.flyproject.models.entities.User;
import com.ProjectFinalArhipovCalin.flyproject.models.FlyRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.FlyResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/v1/flights")
@CrossOrigin("http://localhost:4200/")
public class FlyController {
    public final FlightsService flightsService;

    public FlyController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    //Jpa vine cu toate metodele de CRUD
    //1.luam toti userii din baza //returneaza un userResponse primeste un userRequest
    @PostMapping()
    public ResponseEntity<FlyResponse> createUsers(@Valid @RequestBody FlyRequest flyRequest) {
        try {
            return new ResponseEntity<>(flightsService.createFly(flyRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //2.Sterge user-ul dupa id.
    @DeleteMapping("/{id}")
    public ResponseEntity deleteFlyById(@PathVariable Integer id) {
        flightsService.deleteFly(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //3.Sterge toti userii
    @DeleteMapping("/deleteAll")
    public ResponseEntity<User> deleteAllUsers() {
        flightsService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //4:Ne da o lista de useri din usersRepository(pe toti).
    @GetMapping()
    public ResponseEntity<List<FlyResponse>> getUsers() {
        return new ResponseEntity<>(flightsService.findAll(), HttpStatus.OK);
    }

    //5: Vom lua un user dupa id
    @GetMapping("/{id}") //{id} e o variabila dinamica
    public ResponseEntity<FlyResponse> getFlyById(@PathVariable Integer id) { //Optional lucreaza cu stremuri
        FlyResponse foundFly = flightsService.findById(id); //stocam intr-o variabila
        if (foundFly != null) {                            //daca foundUser diferit de null adica l-am gasit ...
            return new ResponseEntity<>(foundFly, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }

    //6.update
    @PatchMapping("/{id}")
    public ResponseEntity<FlyResponse> updateFly(@PathVariable Integer id, @RequestBody FlyRequest flyRequest) {
        FlyResponse updatedFly = flightsService.updatedFly(id, flyRequest);
        if (updatedFly != null) {
            return new ResponseEntity<>(updatedFly, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(NOT_FOUND);

        }
    }
}
