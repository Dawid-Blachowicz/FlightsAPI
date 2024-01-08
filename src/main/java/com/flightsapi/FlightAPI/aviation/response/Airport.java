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
        "id",
        "gm",
        "gmt",
        "airport_id",
        "iata_code",
        "city_iata_code",
        "icao_code",
        "country_iso2",
        "geoname_id",
        "lattitued",
        "longtitude",
        "airport_name",
        "country_name",
        "phone_number",
        "timezone",
})
public class Airport {
    @JsonProperty("id")
    private String id;
    @JsonProperty("gmt")
    private String gmt;
    @JsonProperty("airport_id")
    private String airportId;
    @JsonProperty("iata_code")
    private String iataCode;
    @JsonProperty("city_iata_code")
    private String cityIataCode;
    @JsonProperty("icao_code")
    private String icaoCode;
    @JsonProperty("country_iso2")
    private String countryIso2;
    @JsonProperty("geoname_id")
    private String geonameId;
    @JsonProperty("lattitued")
    private String latitude;
    @JsonProperty("longtitude")
    private String longitude;
    @JsonProperty("airport_name")
    private String airportName;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("timezone")
    private String timezone;

}

