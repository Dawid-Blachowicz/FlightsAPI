
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
    "number",
    "iata",
    "icao",
    "codeshared"
})
public class Flight {

    @JsonProperty("number")
    public String number;
    @JsonProperty("iata")
    public String iata;
    @JsonProperty("icao")
    public String icao;
    @JsonProperty("codeshared")
    public Object codeshared;

}
