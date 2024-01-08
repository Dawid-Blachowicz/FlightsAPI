
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
    "limit",
    "offset",
    "count",
    "total"
})
public class Pagination {

    @JsonProperty("limit")
    public Integer limit;
    @JsonProperty("offset")
    public Integer offset;
    @JsonProperty("count")
    public Integer count;
    @JsonProperty("total")
    public Integer total;

}
