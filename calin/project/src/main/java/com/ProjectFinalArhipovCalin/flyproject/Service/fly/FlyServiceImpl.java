package com.ProjectFinalArhipovCalin.flyproject.Service.fly;

import com.ProjectFinalArhipovCalin.flyproject.models.entities.Fly;
import com.ProjectFinalArhipovCalin.flyproject.helpers.MapEntities;
import com.ProjectFinalArhipovCalin.flyproject.models.FlyRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.FlyResponse;
import com.ProjectFinalArhipovCalin.flyproject.repository.FlyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlyServiceImpl implements FlightsService {

    private final FlyRepository flyRepository;

    public FlyServiceImpl(FlyRepository flyRepository) {
        this.flyRepository = flyRepository;
    }

    //primim un flyRequest si vrem sa salvam un fly, tre sai facem o mapare
    //de la FlyRequest  Fly.
    @Override
    public FlyResponse createFly(FlyRequest flyRequest) {
        Fly fly = MapEntities.mapFlyRequestToFly(flyRequest);
        var savedFly = this.flyRepository.save(fly);
        return MapEntities.mapFlyToFlyResponse(savedFly);
    }

    @Override
    public void deleteFly(Integer id) {
        this.flyRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.flyRepository.deleteAll();
    }

    @Override
    public List<FlyResponse> findAll() {
        return this.flyRepository.findAll()
                .stream()
                .map(MapEntities::mapFlyToFlyResponse)
                .toList();
    }

    @Override
    public FlyResponse findById(Integer id) {
        Optional<Fly> flyFound = this.flyRepository.findById(id);
        // Fly fly = flyFound.get();
        return flyFound.map(MapEntities::mapFlyToFlyResponse).orElse(null);
    }
//cautam fly dupa id (pui cursorul pe un findById si iti va da un Optional de fly)
    @Override
    public FlyResponse updatedFly(Integer id, FlyRequest flyRequest) {
        Optional<Fly>  flyFound = this.flyRepository.findById(id);
        if (flyFound.isPresent()){
            Fly newFly = flyFound.get();//vrem sa-l abdatam cu proprietatile de pe FlyRequest
            newFly.setReturnDate(flyRequest.getReturnDate());
            newFly.setLanding(flyRequest.getLanding());
            newFly.setPassengers(flyRequest.getPassengers());
            newFly.setDeparture(flyRequest.getDeparture());
            newFly.setReturnDate(flyRequest.getReturnDate());
            this.flyRepository.save(newFly);
           return MapEntities.mapFlyToFlyResponse(newFly);
        }
        return null;
    }
}