package com.example.taxibooking.service.driver;


import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.dto.DriverDto;
import com.example.taxibooking.exception.BusinessException;
import com.example.taxibooking.exception.ExceptionPayloadFactory;
import com.example.taxibooking.mapper.DriverMapper;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.model.ExactLocation;
import com.example.taxibooking.repository.DriverRepository;
import com.example.taxibooking.repository.LocationRepository;
import com.example.taxibooking.service.location.LocationService;
import com.example.taxibooking.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository;
    private final LocationService locationService;

    private final LocationRepository locationRepository;

    private final DriverMapper driverMapper;

    @Override
    public Page<DriverDto> getAllDriver(Pageable pageable) {
        Page<Driver> drivers = driverRepository.findAll(pageable);

        return drivers.map(driverMapper::toDriverDto);
    }

    @Override
    public Driver createDriver(DriverCommand driverCommand) {
        log.info("Begin creating driver with payload {}", JSONUtil.toJSON(driverCommand));

        final ExactLocation lastLocation = driverCommand.getLastLocation() == null ? null : locationService.findById(driverCommand.getLastLocation());
        final ExactLocation home = driverCommand.getDirection() == null ? null : locationService.findById(driverCommand.getDirection());
        final Driver driver = driverRepository.save(Driver.createDriver(driverCommand, lastLocation, home));

        return driver;
    }
    @Override
    public Driver findDriverById(String driverId) {
        final Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.DRIVER_NOT_FOUND.get()));

        return  driver;
    }
    @Override
    public Driver addLastLocationToDriver(String driverId, LocationCommand locationCommand){
        final ExactLocation lastLocation = locationService.createLocation(locationCommand);

        final Driver driver = findDriverById(driverId);
        driver.linkToLastLocation(lastLocation);
        log.info("creating and adding lastLocation with payload {} to driver with id {}", JSONUtil.toJSON(locationCommand), driverId);

        return driverRepository.save(driver);
    }
    public Driver addHomeLocation(String driverId, String customerId){
        return null;
    }

    @Override
    public Driver updateDriverLocation(String driverId, LocationCommand location) {
        final Driver driver = findDriverById(driverId);

        ExactLocation exactLocation = ExactLocation.builder().longitude(location.getLongitude())
                .latitude(location.getLatitude())
                .build();
        driver.setLastKnownLocation(exactLocation);
        return driverRepository.save(driver);
    }
}
