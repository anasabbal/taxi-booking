package com.example.taxibooking.service.notification;

import com.example.taxibooking.model.NotificationCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerNotificationService {

    Page<NotificationCustomer> getAllNotificationCustomer(Pageable pageable);

    NotificationCustomer findNotificationCustomerById(String notificationCustomerId);
}
