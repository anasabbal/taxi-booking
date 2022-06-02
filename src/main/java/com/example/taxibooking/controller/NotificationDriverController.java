package com.example.taxibooking.controller;


import com.example.taxibooking.dto.NotificationDriverDto;
import com.example.taxibooking.mapper.NotificationDriverMapper;
import com.example.taxibooking.model.NotificationDriver;
import com.example.taxibooking.service.notification.driverNotif.DriverNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping("/notification/driver")
@RequiredArgsConstructor
public class NotificationDriverController {
    private final DriverNotificationService driverNotificationService;
    private final NotificationDriverMapper notificationDriverMapper;


    @GetMapping("/all")
    public ResponseEntity<Page<NotificationDriverDto>> getAllNotificationDriver(Pageable pageable){
        return ResponseEntity.ok(driverNotificationService.getAllNotificationDriver(pageable));
    }
    @GetMapping("/{notificationDriverId}")
    public ResponseEntity<NotificationDriverDto> getNotificationDriverId(@PathVariable("notificationDriverId") final String notificationDriverId){
        final NotificationDriver notificationDriver = driverNotificationService.findNotificationDriverById(notificationDriverId);

        return ResponseEntity.ok(notificationDriverMapper.toNotificationDriverDto(notificationDriver));
    }
    @DeleteMapping("/deleteAll/{driverId}")
    public ResponseEntity<?> deleteAllNotificationDriver(@PathVariable("driverId") final String driverId){
        driverNotificationService.clearAllNotificationDriver(driverId);
        return ResponseEntity.noContent().build();
    }
}
