
package com.nwo.libmanager.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "isAvailable",
        "acsTokenLink",
        "downloadLink"
})
public class Epub {

    @JsonProperty("isAvailable")
    private Boolean isAvailable;
    @JsonProperty("acsTokenLink")
    private String acsTokenLink;
    @JsonProperty("downloadLink")
    private String downloadLink;

    @JsonProperty("isAvailable")
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    @JsonProperty("isAvailable")
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @JsonProperty("acsTokenLink")
    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    @JsonProperty("acsTokenLink")
    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }

    @JsonProperty("downloadLink")
    public String getDownloadLink() {
        return downloadLink;
    }

    @JsonProperty("downloadLink")
    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Epub.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("isAvailable");
        sb.append('=');
        sb.append(((this.isAvailable == null) ? "<null>" : this.isAvailable));
        sb.append(',');
        sb.append("acsTokenLink");
        sb.append('=');
        sb.append(((this.acsTokenLink == null) ? "<null>" : this.acsTokenLink));
        sb.append(',');
        sb.append("downloadLink");
        sb.append('=');
        sb.append(((this.downloadLink == null) ? "<null>" : this.downloadLink));
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
        result = ((result * 31) + ((this.isAvailable == null) ? 0 : this.isAvailable.hashCode()));
        result = ((result * 31) + ((this.acsTokenLink == null) ? 0 : this.acsTokenLink.hashCode()));
        result = ((result * 31) + ((this.downloadLink == null) ? 0 : this.downloadLink.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Epub) == false) {
            return false;
        }
        Epub rhs = ((Epub) other);
        return ((((this.isAvailable == rhs.isAvailable) || ((this.isAvailable != null) && this.isAvailable.equals(rhs.isAvailable))) && ((this.acsTokenLink == rhs.acsTokenLink) || ((this.acsTokenLink != null) && this.acsTokenLink.equals(rhs.acsTokenLink)))) && ((this.downloadLink == rhs.downloadLink) || ((this.downloadLink != null) && this.downloadLink.equals(rhs.downloadLink))));
    }

}
