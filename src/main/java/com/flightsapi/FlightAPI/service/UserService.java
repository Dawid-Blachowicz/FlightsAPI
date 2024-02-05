package com.flightsapi.FlightAPI.service;

import com.flightsapi.FlightAPI.dto.UserDTO;
import com.flightsapi.FlightAPI.entity.Token;
import com.flightsapi.FlightAPI.entity.User;
import com.flightsapi.FlightAPI.repository.TokenRepository;
import com.flightsapi.FlightAPI.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final TokenRepository tokenRepository;
    private final EmailSenderService emailService;

    public String createUser(UserDTO user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EntityExistsException("Sorry email is taken already");
        }

       this.userRepository.save(
               modelMapper.map(user, User.class)
       );

        Token token = new Token(user.getEmail());
        tokenRepository.save(token);
        emailService.sendEmail(user.getEmail(), "Account confirmation", token.getValue());

       return token.getValue();
    }

    public List<User> getAllUsers() {
        log.info("Getting all users");
        List<User> all = this.userRepository.findAll();
        User user = all.get(0);
        log.info("getting favourite departures");
        List<String> favouriteDepartures = user.getFavouriteDepartures();

        return null;
    }

    public String verify(String token) {
        Optional<Token> tokenByValue = tokenRepository.getTokenByValue(token);
        if(tokenByValue.isEmpty()) {
        throw new EntityNotFoundException("Token does not exists");
        }
        Token tokenEntity = tokenByValue.get();

        if(!userRepository.existsByEmail(tokenEntity.getEmail())) {
            throw new EntityExistsException("User with given email does not exists");
        }

        if(tokenEntity.getExpDate().isBefore(LocalDateTime.now(ZoneOffset.UTC))) {
            //throw new CredentialsExpiredException("Token has Expired");
        }

        User user = userRepository.getUserByEmail(tokenEntity.getEmail());
        user.setEnabled(true);
        userRepository.save(user);

        tokenEntity.setUsed(true);
        tokenRepository.save(tokenEntity);

        return null;
    }
}
