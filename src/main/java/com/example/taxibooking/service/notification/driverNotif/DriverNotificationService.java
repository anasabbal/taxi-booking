package com.example.taxibooking.service.notification.driverNotif;

import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.NotificationDriver;

public interface DriverNotificationService {

    NotificationDriver cancelRequestCustomerFromNotification(String notificationDriverId, Customer customer);

    NotificationDriver findNotificationDriverById(String notificationDriverId);

}
