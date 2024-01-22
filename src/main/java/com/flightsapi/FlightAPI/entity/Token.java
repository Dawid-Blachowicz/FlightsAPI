package com.flightsapi.FlightAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Token {

    private static final int EXP_TIME = 14;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String value;
    private String email;
    private LocalDateTime expDate;
    private boolean isUsed = false;

    public Token(String email) {
        this.email = email;
        this.value = UUID.randomUUID().toString();
        this.expDate = LocalDateTime.now(ZoneOffset.UTC).plusDays(EXP_TIME);
    }
}
