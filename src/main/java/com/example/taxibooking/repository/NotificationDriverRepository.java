package com.example.taxibooking.repository;

import com.example.taxibooking.model.NotificationDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationDriverRepository extends JpaRepository<NotificationDriver, String> {
}
