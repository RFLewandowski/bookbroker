
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
        "requestedUrl",
        "items"
})
public class Books {
    @JsonProperty("requestedUrl")
    private String requestedUrl;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
}
