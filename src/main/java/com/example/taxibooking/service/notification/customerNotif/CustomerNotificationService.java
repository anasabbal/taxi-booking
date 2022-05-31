package com.example.taxibooking.service.notification.customerNotif;

import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.model.NotificationCustomer;
import com.example.taxibooking.model.NotificationDriver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerNotificationService {

    Page<NotificationCustomer> getAllNotificationCustomer(Pageable pageable);

    NotificationCustomer findNotificationCustomerById(String notificationCustomerId);

    NotificationDriver sendRequestToDriver(String customerId, NotificationDriver notificationCustomerId);
}
