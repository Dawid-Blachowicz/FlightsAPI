
package com.flightsapi.FlightAPI.aviation.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pagination",
    "data"
})
public class AviationResponse {

    @JsonProperty("pagination")
    public Pagination pagination;
    @JsonProperty("data")
    public List<Datum> data;

}
