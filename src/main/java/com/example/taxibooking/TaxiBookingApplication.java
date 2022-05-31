package com.example.taxibooking;


import com.example.taxibooking.model.NotificationCustomer;
import com.example.taxibooking.repository.CustomerRepository;
import com.example.taxibooking.repository.NotificationCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class TaxiBookingApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final NotificationCustomerRepository notificationCustomerRepository;

    public static void main(String[] args) {
        SpringApplication.run(TaxiBookingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
