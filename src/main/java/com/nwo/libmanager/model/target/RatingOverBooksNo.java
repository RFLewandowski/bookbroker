package com.nwo.libmanager.model.target;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode

public class RatingOverBooksNo {
    private Double sumRating;
    private Integer noOfBooks;

    public RatingOverBooksNo(Double sumRating) {
        noOfBooks = 1;
        this.sumRating = sumRating;
    }

    public void updateRating(Double sumRating) {
        noOfBooks++;
        this.sumRating += sumRating;
    }

    public Double getRating() {
        return sumRating / noOfBooks;
    }
}
