package com.example.taxibooking.repository;

import com.example.taxibooking.model.ExactLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<ExactLocation, String> {
}
