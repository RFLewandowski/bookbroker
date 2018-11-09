
package com.nwo.libmanager.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "textSnippet"
})
public class SearchInfo {

    @JsonProperty("textSnippet")
    private String textSnippet;

    @JsonProperty("textSnippet")
    public String getTextSnippet() {
        return textSnippet;
    }

    @JsonProperty("textSnippet")
    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SearchInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("textSnippet");
        sb.append('=');
        sb.append(((this.textSnippet == null) ? "<null>" : this.textSnippet));
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
        result = ((result * 31) + ((this.textSnippet == null) ? 0 : this.textSnippet.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchInfo) == false) {
            return false;
        }
        SearchInfo rhs = ((SearchInfo) other);
        return ((this.textSnippet == rhs.textSnippet) || ((this.textSnippet != null) && this.textSnippet.equals(rhs.textSnippet)));
    }

}
