
package com.nwo.libmanager.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "country",
        "saleability",
        "isEbook",
        "buyLink",
        "listPrice",
        "retailPrice",
        "offers"
})
public class SaleInfo {

    @JsonProperty("country")
    private String country;
    @JsonProperty("saleability")
    private String saleability;
    @JsonProperty("isEbook")
    private Boolean isEbook;
    @JsonProperty("buyLink")
    private String buyLink;
    @JsonProperty("listPrice")
    private ListPrice listPrice;
    @JsonProperty("retailPrice")
    private RetailPrice retailPrice;
    @JsonProperty("offers")
    private List<Offer> offers = new ArrayList<Offer>();
}
