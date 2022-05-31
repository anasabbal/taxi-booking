package com.example.taxibooking.service.notification.customerNotif;


import com.example.taxibooking.model.NotificationCustomer;
import com.example.taxibooking.repository.NotificationCustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerNotificationServiceImpl implements CustomerNotificationService{

    private final NotificationCustomerRepository notificationCustomerRepository;


    @Override
    public Page<NotificationCustomer> getAllNotificationCustomer(Pageable pageable) {
        return notificationCustomerRepository.findAll(pageable);
    }

    @Override
    public NotificationCustomer findNotificationCustomerById(String notificationCustomerId) {
        final NotificationCustomer notificationCustomer = notificationCustomerRepository.findById(notificationCustomerId).get();

        return notificationCustomer;
    }
}
