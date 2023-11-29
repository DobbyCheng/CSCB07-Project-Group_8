package com.example.comment_and_rating;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHandler {

    private DatabaseReference databaseReference;

    public FirebaseHandler() {
        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
    }

    // Method to add or edit comment and rating for an event
    public void addOrUpdateFeedback(String eventName, String studentUsername, String comment, int rating) {
        DatabaseReference eventRef = databaseReference.child("events").child(eventName);
        DatabaseReference studentRef = eventRef.child("Students Attending").child(studentUsername).child("feedback");

        studentRef.child("comment").setValue(comment);
        studentRef.child("rating").setValue(rating);
        studentRef.child("rating maker").setValue(studentUsername);
    }

    // Method to retrieve comments and ratings for an event
    public void getFeedbackForEvent(String eventName) {
        DatabaseReference eventRef = databaseReference.child("events").child(eventName);

        // Loop through students attending and retrieve feedback
        eventRef.child("Students Attending").get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                for (DataSnapshot studentSnapshot : task.getResult().getChildren()) {
                    String studentUsername = studentSnapshot.getKey();
                    String comment = studentSnapshot.child("feedback").child("comment").getValue(String.class);
                    int rating = studentSnapshot.child("feedback").child("rating").getValue(Integer.class);

                    // Do something with comment and rating (e.g., display on UI)
                    System.out.println("Student: " + studentUsername + ", Comment: " + comment + ", Rating: " + rating);
                }
            }
        });
    }
}
