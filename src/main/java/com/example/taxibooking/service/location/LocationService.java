package com.example.taxibooking.service.location;

import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.model.ExactLocation;

public interface LocationService {
    ExactLocation createLocation(LocationCommand locationCommand);

    ExactLocation findById(String locationId);

    ExactLocation update(String locationId , LocationCommand locationCommand);
}
