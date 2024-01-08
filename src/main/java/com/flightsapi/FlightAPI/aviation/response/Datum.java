
package com.flightsapi.FlightAPI.aviation.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "flight_date",
    "flight_status",
    "departure",
    "arrival",
    "airline",
    "flight",
    "aircraft",
    "live"
})
public class Datum {

    @JsonProperty("flight_date")
    public String flightDate;
    @JsonProperty("flight_status")
    public String flightStatus;
    @JsonProperty("departure")
    public Departure departure;
    @JsonProperty("arrival")
    public Arrival arrival;
    @JsonProperty("airline")
    public Airline airline;
    @JsonProperty("flight")
    public Flight flight;
    @JsonProperty("aircraft")
    public Object aircraft;
    @JsonProperty("live")
    public Object live;

}
