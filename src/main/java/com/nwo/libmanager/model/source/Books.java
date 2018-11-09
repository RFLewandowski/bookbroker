
package com.nwo.libmanager.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

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

    @JsonProperty("requestedUrl")
    public String getRequestedUrl() {
        return requestedUrl;
    }

    @JsonProperty("requestedUrl")
    public void setRequestedUrl(String requestedUrl) {
        this.requestedUrl = requestedUrl;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Books.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("requestedUrl");
        sb.append('=');
        sb.append(((this.requestedUrl == null) ? "<null>" : this.requestedUrl));
        sb.append(',');
        sb.append("items");
        sb.append('=');
        sb.append(((this.items == null) ? "<null>" : this.items));
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
        result = ((result * 31) + ((this.items == null) ? 0 : this.items.hashCode()));
        result = ((result * 31) + ((this.requestedUrl == null) ? 0 : this.requestedUrl.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Books) == false) {
            return false;
        }
        Books rhs = ((Books) other);
        return (((this.items == rhs.items) || ((this.items != null) && this.items.equals(rhs.items))) && ((this.requestedUrl == rhs.requestedUrl) || ((this.requestedUrl != null) && this.requestedUrl.equals(rhs.requestedUrl))));
    }

}
