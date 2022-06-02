package com.example.taxibooking.service.notification.driverNotif;


import com.example.taxibooking.dto.NotificationDriverDto;
import com.example.taxibooking.mapper.NotificationDriverMapper;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.model.NotificationDriver;
import com.example.taxibooking.repository.NotificationDriverRepository;
import com.example.taxibooking.service.driver.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriverNotificationServiceImpl implements DriverNotificationService{

    private final NotificationDriverRepository notificationDriverRepository;
    private final DriverService driverService;
    private final NotificationDriverMapper notificationDriverMapper;

    @Override
    public Page<NotificationDriverDto> getAllNotificationDriver(Pageable pageable) {
        Page<NotificationDriver> notificationDrivers = notificationDriverRepository.findAll(pageable);
        return notificationDrivers.map(notificationDriverMapper::toNotificationDriverDto);
    }

    @Override
    public NotificationDriver findNotificationDriverById(String notificationDriverId) {
        final NotificationDriver notificationDriver = notificationDriverRepository.findById(notificationDriverId).get();
        return notificationDriver;
    }

    @Override
    public void clearAllNotificationDriver(String driverId) {
        final Driver driver = driverService.findDriverById(driverId);

        final NotificationDriver notificationDriver = driver.getNotificationDriver();
        notificationDriver.clearAll();
    }
}
