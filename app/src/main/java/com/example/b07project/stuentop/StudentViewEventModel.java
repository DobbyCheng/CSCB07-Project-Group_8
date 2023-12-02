package com.example.b07project.stuentop;

public class StudentViewEventModel {
    private String name;
    private String description;
    private String time;
    private String date;
    private int eventId, ratingSum, ratingNum;

    public StudentViewEventModel(String name, String description, String time,
                                 String date, int eventId, int ratingSum, int ratingNum) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.date = date;
        this.eventId = eventId;
        this.ratingSum = ratingSum;
        this.ratingNum = ratingNum;
    }

    // Getter methods
    public String getName() {
        return "name: "+name;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getEventId() {
        return String.valueOf(eventId);
    }


    public String getRating() {
        String formattedNumber = String.format("%.2f", (double)ratingSum / (double)ratingNum);
        return "rating: "+formattedNumber;
    }

    // Setter methods (if needed)

    // Other methods as needed

    // toString method
}
