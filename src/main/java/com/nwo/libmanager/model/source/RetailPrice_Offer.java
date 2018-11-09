
package com.nwo.libmanager.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "amountInMicros",
        "currencyCode"
})
public class RetailPrice_Offer {

    @JsonProperty("amountInMicros")
    private Double amountInMicros;
    @JsonProperty("currencyCode")
    private String currencyCode;

    @JsonProperty("amountInMicros")
    public Double getAmountInMicros() {
        return amountInMicros;
    }

    @JsonProperty("amountInMicros")
    public void setAmountInMicros(Double amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetailPrice_Offer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("amountInMicros");
        sb.append('=');
        sb.append(((this.amountInMicros == null) ? "<null>" : this.amountInMicros));
        sb.append(',');
        sb.append("currencyCode");
        sb.append('=');
        sb.append(((this.currencyCode == null) ? "<null>" : this.currencyCode));
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
        result = ((result * 31) + ((this.currencyCode == null) ? 0 : this.currencyCode.hashCode()));
        result = ((result * 31) + ((this.amountInMicros == null) ? 0 : this.amountInMicros.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetailPrice_Offer) == false) {
            return false;
        }
        RetailPrice_Offer rhs = ((RetailPrice_Offer) other);
        return (((this.currencyCode == rhs.currencyCode) || ((this.currencyCode != null) && this.currencyCode.equals(rhs.currencyCode))) && ((this.amountInMicros == rhs.amountInMicros) || ((this.amountInMicros != null) && this.amountInMicros.equals(rhs.amountInMicros))));
    }

}
