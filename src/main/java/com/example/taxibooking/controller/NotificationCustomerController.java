package com.example.taxibooking.controller;

import com.example.taxibooking.model.NotificationCustomer;
import com.example.taxibooking.service.notification.customerNotif.CustomerNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customers/notification")
@RequiredArgsConstructor
public class NotificationCustomerController {

    private final CustomerNotificationService customerNotificationService;

    @GetMapping("/customers/notification")
    public ResponseEntity<Page<NotificationCustomer>> getAllNotificationsCustomer(Pageable pageable){
        return ResponseEntity.ok(customerNotificationService.getAllNotificationCustomer(pageable));
    }
    @GetMapping("/customers/notification/{customerId}")
    public ResponseEntity<NotificationCustomer> getNotificationCustomerId(@PathVariable("customerId") final String customerId){
        return ResponseEntity.ok(customerNotificationService.findNotificationCustomerById(customerId));
    }
}
