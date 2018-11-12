package com.nwo.libmanager.model.target;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Rating {
    private Double sumOfRatings;//actual sum, not current rating
    private Integer numberOfBooks;

    public Rating(Double sumRating) {
        numberOfBooks = 1;
        this.sumOfRatings = sumRating;
    }

    /**
     * Updates Rating instance with new value
     *
     * @param value value of new averageRating of book to add
     */
    public void updateRating(Double value) {
        numberOfBooks++;
        this.sumOfRatings += value;
    }

    public Double getRating() {
        return sumOfRatings / numberOfBooks;
    }
}
