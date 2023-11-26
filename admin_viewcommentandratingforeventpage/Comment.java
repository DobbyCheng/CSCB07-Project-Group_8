package com.example.admin_viewcommentandratingforeventpage;

public class Comment {
    private String CommentID;
    private String text;
    private int rating;
    private String studentId;
    private String eventId;
    public String getText() {
        return text;
    }
    public Comment() {
    }

    // Constructor with parameters
    public Comment(String commentID, String text, int rating, String studentId, String eventId) {
        this.CommentID = commentID;
        this.text = text;
        this.rating = rating;
        this.studentId = studentId;
        this.eventId = eventId;
    }
    public void setCommentID(String commentID) {
        CommentID = commentID;
    }

    public String getCommentID() {
        return CommentID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
