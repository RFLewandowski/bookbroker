
package com.nwo.libmanager.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "smallThumbnail",
        "thumbnail"
})
public class ImageLinks {

    @JsonProperty("smallThumbnail")
    private String smallThumbnail;
    @JsonProperty("thumbnail")
    private String thumbnail;

    @JsonProperty("smallThumbnail")
    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    @JsonProperty("smallThumbnail")
    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ImageLinks.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("smallThumbnail");
        sb.append('=');
        sb.append(((this.smallThumbnail == null) ? "<null>" : this.smallThumbnail));
        sb.append(',');
        sb.append("thumbnail");
        sb.append('=');
        sb.append(((this.thumbnail == null) ? "<null>" : this.thumbnail));
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
        result = ((result * 31) + ((this.thumbnail == null) ? 0 : this.thumbnail.hashCode()));
        result = ((result * 31) + ((this.smallThumbnail == null) ? 0 : this.smallThumbnail.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ImageLinks) == false) {
            return false;
        }
        ImageLinks rhs = ((ImageLinks) other);
        return (((this.thumbnail == rhs.thumbnail) || ((this.thumbnail != null) && this.thumbnail.equals(rhs.thumbnail))) && ((this.smallThumbnail == rhs.smallThumbnail) || ((this.smallThumbnail != null) && this.smallThumbnail.equals(rhs.smallThumbnail))));
    }

}
