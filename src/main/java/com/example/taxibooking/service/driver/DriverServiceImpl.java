package com.example.taxibooking.service.driver;


import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.model.Driver;
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
}
