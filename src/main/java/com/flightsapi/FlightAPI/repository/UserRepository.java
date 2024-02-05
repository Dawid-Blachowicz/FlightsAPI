package com.flightsapi.FlightAPI.repository;

import com.flightsapi.FlightAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);

    User getUserByEmail(String email);
}
