
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
        "country",
        "viewability",
        "embeddable",
        "publicDomain",
        "textToSpeechPermission",
        "epub",
        "pdf",
        "webReaderLink",
        "accessViewStatus",
        "quoteSharingAllowed"
})
class AccessInfo {
    @JsonProperty("country")
    private String country;
    @JsonProperty("viewability")
    private String viewability;
    @JsonProperty("embeddable")
    private Boolean embeddable;
    @JsonProperty("publicDomain")
    private Boolean publicDomain;
    @JsonProperty("textToSpeechPermission")
    private String textToSpeechPermission;
    @JsonProperty("epub")
    private Epub epub;
    @JsonProperty("pdf")
    private Pdf pdf;
    @JsonProperty("webReaderLink")
    private String webReaderLink;
    @JsonProperty("accessViewStatus")
    private String accessViewStatus;
    @JsonProperty("quoteSharingAllowed")
    private Boolean quoteSharingAllowed;

}
