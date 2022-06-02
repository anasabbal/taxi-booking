package com.example.taxibooking.service.notification.driverNotif;

import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.NotificationDriver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DriverNotificationService {
    Page<NotificationDriver> getAllNotificationDriver(Pageable pageable);
    NotificationDriver findNotificationDriverById(String notificationDriverId);
    void clearAllNotificationDriver(String driverId);

}
