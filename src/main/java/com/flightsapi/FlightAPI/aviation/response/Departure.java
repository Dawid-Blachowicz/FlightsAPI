
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
    "airport",
    "timezone",
    "iata",
    "icao",
    "terminal",
    "gate",
    "delay",
    "scheduled",
    "estimated",
    "actual",
    "estimated_runway",
    "actual_runway"
})
public class Departure {

    @JsonProperty("airport")
    public String airport;
    @JsonProperty("timezone")
    public String timezone;
    @JsonProperty("iata")
    public String iata;
    @JsonProperty("icao")
    public String icao;
    @JsonProperty("terminal")
    public Object terminal;
    @JsonProperty("gate")
    public Object gate;
    @JsonProperty("delay")
    public Object delay;
    @JsonProperty("scheduled")
    public String scheduled;
    @JsonProperty("estimated")
    public String estimated;
    @JsonProperty("actual")
    public Object actual;
    @JsonProperty("estimated_runway")
    public Object estimatedRunway;
    @JsonProperty("actual_runway")
    public Object actualRunway;

}
