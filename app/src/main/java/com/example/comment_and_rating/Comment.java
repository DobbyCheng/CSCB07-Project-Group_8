package com.example.comment_and_rating;

public class Comment {
    private String comment;
    private int rating;
    private String ratingMaker;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingMaker() {
        return ratingMaker;
    }

    public void setRatingMaker(String ratingMaker) {
        this.ratingMaker = ratingMaker;
    }
}
