package com.example.admin_viewcommentandratingforeventpage;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

public class CommentRatingManager {
    private DatabaseReference databaseReference;

    public CommentRatingManager() {
        // Initialize Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        // Set the reference to the "events" node in your database
        databaseReference = firebaseDatabase.getReference("events");
    }

    public void addCommentAndRating(String eventId, String studentId, String commentText, int rating) {
        // Create a unique key for the new comment
        String commentId = databaseReference.child(eventId).child("comments").push().getKey();

        // Create a Comment object
        Comment comment = new Comment(commentId, commentText, rating, studentId, eventId);

        // Save the comment to the "comments" node under the specified event
        databaseReference.child(eventId).child("comments").child(commentId).setValue(comment);

        // Update the event's overall rating (you may need to handle this based on your specific structure)
        updateEventRating(eventId, rating);
    }
}
