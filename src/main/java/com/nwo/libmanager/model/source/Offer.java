
package com.nwo.libmanager.model.source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "finskyOfferType",
        "listPrice",
        "retailPrice"
})
public class Offer {

    @JsonProperty("finskyOfferType")
    private Integer finskyOfferType;
    @JsonProperty("listPrice")
    private ListPrice_Offer listPrice;
    @JsonProperty("retailPrice")
    private RetailPrice_Offer retailPrice;

    @JsonProperty("finskyOfferType")
    public Integer getFinskyOfferType() {
        return finskyOfferType;
    }

    @JsonProperty("finskyOfferType")
    public void setFinskyOfferType(Integer finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    @JsonProperty("listPrice")
    public ListPrice_Offer getListPrice() {
        return listPrice;
    }

    @JsonProperty("listPrice")
    public void setListPrice(ListPrice_Offer listPrice) {
        this.listPrice = listPrice;
    }

    @JsonProperty("retailPrice")
    public RetailPrice_Offer getRetailPrice() {
        return retailPrice;
    }

    @JsonProperty("retailPrice")
    public void setRetailPrice(RetailPrice_Offer retailPrice) {
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Offer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("finskyOfferType");
        sb.append('=');
        sb.append(((this.finskyOfferType == null) ? "<null>" : this.finskyOfferType));
        sb.append(',');
        sb.append("listPrice");
        sb.append('=');
        sb.append(((this.listPrice == null) ? "<null>" : this.listPrice));
        sb.append(',');
        sb.append("retailPrice");
        sb.append('=');
        sb.append(((this.retailPrice == null) ? "<null>" : this.retailPrice));
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
        result = ((result * 31) + ((this.finskyOfferType == null) ? 0 : this.finskyOfferType.hashCode()));
        result = ((result * 31) + ((this.retailPrice == null) ? 0 : this.retailPrice.hashCode()));
        result = ((result * 31) + ((this.listPrice == null) ? 0 : this.listPrice.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Offer) == false) {
            return false;
        }
        Offer rhs = ((Offer) other);
        return ((((this.finskyOfferType == rhs.finskyOfferType) || ((this.finskyOfferType != null) && this.finskyOfferType.equals(rhs.finskyOfferType))) && ((this.retailPrice == rhs.retailPrice) || ((this.retailPrice != null) && this.retailPrice.equals(rhs.retailPrice)))) && ((this.listPrice == rhs.listPrice) || ((this.listPrice != null) && this.listPrice.equals(rhs.listPrice))));
    }

}
