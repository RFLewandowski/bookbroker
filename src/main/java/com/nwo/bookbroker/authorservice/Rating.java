package com.nwo.bookbroker.authorservice;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
class Rating {
    private Double sumOfRatings;//actual sum, not current rating
    private Integer numberOfBooks;

    Rating(Double sumRating) {
        numberOfBooks = 1;
        this.sumOfRatings = sumRating;
    }

    /**
     * Updates Rating instance with new value
     *
     * @param value value of new averageRating of book to add
     */
    void updateRating(Double value) {
        numberOfBooks++;
        this.sumOfRatings += value;
    }

    Double getRating() {
        return this.sumOfRatings / this.numberOfBooks;
    }
}
