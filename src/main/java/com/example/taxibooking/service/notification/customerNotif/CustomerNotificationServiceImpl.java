package com.example.taxibooking.service.notification.customerNotif;


import com.example.taxibooking.dto.NotificationCustomerDto;
import com.example.taxibooking.mapper.NotificationCustomerMapper;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.model.NotificationCustomer;
import com.example.taxibooking.model.NotificationDriver;
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
    private final NotificationCustomerMapper notificationCustomerMapper;


    @Override
    public Page<NotificationCustomerDto> getAllNotificationCustomer(Pageable pageable) {
        Page<NotificationCustomer> notificationCustomers = notificationCustomerRepository.findAll(pageable);
        return notificationCustomers.map(notificationCustomerMapper::toNotificationCustomerDto);
    }

    @Override
    public NotificationCustomer findNotificationCustomerById(String notificationCustomerId) {
        final NotificationCustomer notificationCustomer = notificationCustomerRepository.findById(notificationCustomerId).get();

        return notificationCustomer;
    }

    @Override
    public NotificationDriver sendRequestToDriver(String customerId, NotificationDriver notificationCustomerId) {
        return null;
    }
}
