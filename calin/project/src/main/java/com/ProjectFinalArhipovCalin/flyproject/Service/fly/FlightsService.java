package com.ProjectFinalArhipovCalin.flyproject.Service.fly;

import com.ProjectFinalArhipovCalin.flyproject.models.FlyRequest;
import com.ProjectFinalArhipovCalin.flyproject.models.FlyResponse;

import java.util.List;

public interface FlightsService {

    FlyResponse createFly(FlyRequest flyRequest);

    void deleteFly(Integer id);

    void deleteAll();

    List<FlyResponse> findAll();

    FlyResponse findById(Integer id);

    FlyResponse updatedFly(Integer id, FlyRequest flyRequest);
}
