package com.example.taxibooking.service.driver;


import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.exception.BusinessException;
import com.example.taxibooking.exception.ExceptionPayloadFactory;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.model.ExactLocation;
import com.example.taxibooking.repository.DriverRepository;
import com.example.taxibooking.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository;
    @Override
    public Driver createDriver(DriverCommand driverCommand) {
        log.info("Begin creating driver with payload {}", JSONUtil.toJSON(driverCommand));

        return null;
    }
    @Override
    public Driver findDriverById(String driverId) {
        final Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.DRIVER_NOT_FOUND.get()));

        return  driver;
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
