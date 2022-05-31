package com.example.taxibooking.service.notification.driverNotif;


import com.example.taxibooking.repository.NotificationDriverRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriverNotificationServiceImpl implements DriverNotificationService{

    private final NotificationDriverRepository notificationDriverRepository;
}
