
package com.nwo.libmanager.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "containsEpubBubbles",
        "containsImageBubbles"
})
public class PanelizationSummary {

    @JsonProperty("containsEpubBubbles")
    private Boolean containsEpubBubbles;
    @JsonProperty("containsImageBubbles")
    private Boolean containsImageBubbles;

    @JsonProperty("containsEpubBubbles")
    public Boolean getContainsEpubBubbles() {
        return containsEpubBubbles;
    }

    @JsonProperty("containsEpubBubbles")
    public void setContainsEpubBubbles(Boolean containsEpubBubbles) {
        this.containsEpubBubbles = containsEpubBubbles;
    }

    @JsonProperty("containsImageBubbles")
    public Boolean getContainsImageBubbles() {
        return containsImageBubbles;
    }

    @JsonProperty("containsImageBubbles")
    public void setContainsImageBubbles(Boolean containsImageBubbles) {
        this.containsImageBubbles = containsImageBubbles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PanelizationSummary.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("containsEpubBubbles");
        sb.append('=');
        sb.append(((this.containsEpubBubbles == null) ? "<null>" : this.containsEpubBubbles));
        sb.append(',');
        sb.append("containsImageBubbles");
        sb.append('=');
        sb.append(((this.containsImageBubbles == null) ? "<null>" : this.containsImageBubbles));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.containsEpubBubbles == null) ? 0 : this.containsEpubBubbles.hashCode()));
        result = ((result * 31) + ((this.containsImageBubbles == null) ? 0 : this.containsImageBubbles.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PanelizationSummary) == false) {
            return false;
        }
        PanelizationSummary rhs = ((PanelizationSummary) other);
        return (((this.containsEpubBubbles == rhs.containsEpubBubbles) || ((this.containsEpubBubbles != null) && this.containsEpubBubbles.equals(rhs.containsEpubBubbles))) && ((this.containsImageBubbles == rhs.containsImageBubbles) || ((this.containsImageBubbles != null) && this.containsImageBubbles.equals(rhs.containsImageBubbles))));
    }

}
