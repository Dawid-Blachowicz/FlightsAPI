package com.flightsapi.FlightAPI.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@Component
public class RestExceptionHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        String body = new BufferedReader(new InputStreamReader(response.getBody()))
                .lines().collect(Collectors.joining("\n"));

        HttpStatusCode statusCode = response.getStatusCode();

        if (statusCode.equals(BAD_REQUEST)) {
            throw new BadRequestException(body);
        } else if (statusCode.equals(UNAUTHORIZED)) {
            throw new UnauthorizedException(body);
        } else if (statusCode.equals(FORBIDDEN)) {
            throw new ForbiddenException(body);
        } else if (statusCode.equals(NOT_FOUND)) {
            throw new ResourceNotFoundException(body);
        } else if (statusCode.equals(INTERNAL_SERVER_ERROR)) {
            throw new InternalServerErrorException(body);
        }
        throw new GeneralHttpException("Unexpected HTTP status: " + statusCode, body);
    }

    private static class BadRequestException extends RuntimeException {
        public BadRequestException(String message) { super(message); }
    }

    private static class UnauthorizedException extends RuntimeException {
        public UnauthorizedException(String message) { super(message); }
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        ResponseErrorHandler.super.handleError(url, method, response);
    }
}

class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) { super(message); }
}

class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) { super(message); }
}

class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) { super(message); }
}

class GeneralHttpException extends RuntimeException {
    public GeneralHttpException(String message, String body) {
        super(message + " Response Body: " + body);
    }
}

