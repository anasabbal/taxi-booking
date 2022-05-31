package com.example.taxibooking.service.notification.driverNotif;


import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.NotificationDriver;
import com.example.taxibooking.repository.NotificationDriverRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriverNotificationServiceImpl implements DriverNotificationService{

    private final NotificationDriverRepository notificationDriverRepository;

    @Override
    public NotificationDriver cancelRequestCustomerFromNotification(String notificationDriverId, Customer customer) {
        final NotificationDriver notificationDriver = findNotificationDriverById(notificationDriverId);
        notificationDriver.removeFrom(customer);

        return notificationDriver;
    }
    @Override
    public NotificationDriver findNotificationDriverById(String notificationDriverId) {
        final NotificationDriver notificationDriver = notificationDriverRepository.findById(notificationDriverId).get();
        return notificationDriver;
    }

}
