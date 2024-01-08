package com.flightsapi.FlightAPI.service;

import com.flightsapi.FlightAPI.dto.UserDTO;
import com.flightsapi.FlightAPI.entity.User;
import com.flightsapi.FlightAPI.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public String createUser(UserDTO user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EntityExistsException("Sorry email is taken already");
        }

       this.userRepository.save(
               modelMapper.map(user, User.class)
       );

       //TODO Dodaj modelMapper/objectMapper do projektu
        // TODO Dodaj exceptionHandler do restTemplateBuilder
        //TODO Zmienic wszedzie na User na UserDTO

       return "User registered successfully";
    }

    public List<User> getAllUsers() {
        log.info("Getting all users");
        List<User> all = this.userRepository.findAll();
        User user = all.get(0);
        log.info("getting favourite departures");
        List<String> favouriteDepartures = user.getFavouriteDepartures();


        return null;
    }

}
