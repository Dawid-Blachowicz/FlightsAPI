
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
    "name",
    "iata",
    "icao"
})
public class Airline {

    @JsonProperty("name")
    public String name;
    @JsonProperty("iata")
    public String iata;
    @JsonProperty("icao")
    public String icao;

}
