package com.flightsapi.FlightAPI.exception;

class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
