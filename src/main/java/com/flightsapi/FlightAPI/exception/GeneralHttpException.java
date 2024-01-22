package com.flightsapi.FlightAPI.exception;

class GeneralHttpException extends RuntimeException {
    public GeneralHttpException(String message, String body) {
        super(message + " Response Body: " + body);
    }
}
