package com.example.taxibooking.service.location;


import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.exception.BusinessException;
import com.example.taxibooking.exception.ExceptionPayload;
import com.example.taxibooking.exception.ExceptionPayloadFactory;
import com.example.taxibooking.model.ExactLocation;
import com.example.taxibooking.repository.LocationRepository;
import com.example.taxibooking.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService{
    private final LocationRepository locationRepository;

    @Override
    public ExactLocation createLocation(LocationCommand locationCommand) {
        log.info("Begin creating Location with payload {}", JSONUtil.toJSON(locationCommand));
        locationCommand.validate();

        final ExactLocation location = locationRepository.save(ExactLocation.createLocation(locationCommand));

        return location;
    }
    @Override
    public ExactLocation findById(String locationId) {
        log.info("Begin fetching location with id {}", locationId);

        final ExactLocation location = locationRepository.findById(locationId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.LOCATION_NOT_FOUND.get()));

        return location;
    }

    @Override
    public ExactLocation update(String locationId, LocationCommand locationCommand) {
        log.info("Begin fetching location with id {}", locationId);
        final ExactLocation location = findById(locationId);
        locationCommand.validate();

        log.info("Begin updating location with payload {}", JSONUtil.toJSON(location));
        location.updateLocation(locationCommand);
        log.info("Updating location with id {} Done !", locationId);

        return locationRepository.save(location);
    }
}
