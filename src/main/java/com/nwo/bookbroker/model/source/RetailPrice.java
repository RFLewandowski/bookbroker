
package com.nwo.bookbroker.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "amount",
        "currencyCode"
})
class RetailPrice {
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("currencyCode")
    private String currencyCode;
}
