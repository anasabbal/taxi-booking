package com.example.taxibooking.repository;

import com.example.taxibooking.model.NotificationCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationCustomerRepository extends JpaRepository<NotificationCustomer, String>{
}
