package com.example.taxibooking;


import com.example.taxibooking.enums.DriverType;
import com.example.taxibooking.enums.Gender;
import com.example.taxibooking.model.*;
import com.example.taxibooking.repository.CustomerRepository;
import com.example.taxibooking.repository.DriverRepository;
import com.example.taxibooking.repository.NotificationCustomerRepository;
import com.example.taxibooking.repository.NotificationDriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class TaxiBookingApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(TaxiBookingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*ExactLocation location = new ExactLocation();
        location.setLatitude(121421.000);
        location.setLongitude(12412.1241);

        Driver driver = new Driver();
        driver.setDriverType(DriverType.TAXI);
        driverRepository.save(driver);

        NotificationCustomer notificationCustomer = new NotificationCustomer();
        notificationCustomer.linkToDriverNotification(driver);




        Customer customer = new Customer();
        customer.setFirstName("anas");
        customer.setEmail("anas.abbal10@gmail");
        customer.setPhone("0766539731");
        customer.setGender(Gender.MALE);
        customer.setHome(location);
        customer.setWork(location);
        customer.setLastKnownLocation(location);
        //customer.setDriver(driver);

        //ustomerRepository.save(customer);
        NotificationDriver notificationDriver = new NotificationDriver();
        notificationDriver.linkToCustomer(customer);

        notificationDriverRepository.save(notificationDriver);
        //customerRepository.save(customer);*/
    }
}
