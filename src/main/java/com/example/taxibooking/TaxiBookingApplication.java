package com.example.taxibooking;

import com.example.taxibooking.enums.DriverStatus;
import com.example.taxibooking.enums.DriverType;
import com.example.taxibooking.enums.Gender;
import com.example.taxibooking.enums.UserType;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.model.ExactLocation;
import com.example.taxibooking.repository.CustomerRepository;
import com.example.taxibooking.repository.DriverRepository;
import com.example.taxibooking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TaxiBookingApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LocationRepository locationRepository;


    public static void main(String[] args) {
        SpringApplication.run(TaxiBookingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ExactLocation location = new ExactLocation();
        location.setLatitude(121421.000);
        location.setLongitude(12412.1241);
        locationRepository.save(location);


        Customer customer = new Customer();
        customer.setFirstName("anas");
        customer.setLastName("abbal");
        customer.setEmail("anas.abbal10@gmail");
        customer.setPhone("0766539731");
        customer.setRole(UserType.USER);
        customer.setGender(Gender.MALE);
        customer.setHome(location);
        customer.setWork(location);
        customer.setLastKnownLocation(location);

        customerRepository.save(customer);

    }
}
