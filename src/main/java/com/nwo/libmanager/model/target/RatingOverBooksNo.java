package com.nwo.libmanager.model.target;

import lombok.Data;

@Data
public class RatingOverBooksNo {
    Double sumRating;
    Integer noOfBooks;

    public void setForNewAuthor(Double rating) {
        this.sumRating = rating;
        noOfBooks = 1;
    }

    public Double getFinalRating() {
        return sumRating / noOfBooks;
    }
}
