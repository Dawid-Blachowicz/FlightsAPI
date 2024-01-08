package com.flightsapi.FlightAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FlightApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightApiApplication.class, args);
	}

    @RestController
    @RequestMapping("/api/v1")
    public static class FlightsController {

    }
}
