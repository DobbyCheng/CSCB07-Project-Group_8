package com.example.b07project.adminop;

import java.util.List;

public class Event {

    private int participantLimit;
    private String description;
    private String eventName;
    private String date;
    private String time;

    private  String commentlist;
    private  String participant;

    private int EventID ;
    int ratingNum;
    int ratingSum;
    int left;


    public Event() {
        // Default constructor required for Firebase
    }

    public Event(int participantLimit, String date, String time,
                 String eventName,String description, int EventID) {
        this.participantLimit = participantLimit;
        this.date = date;
        this.time = time;
        this.eventName = eventName;
        this.description = description;
        this.EventID= EventID;
        this.commentlist = "";
        this.ratingNum=0;
        this.ratingSum=0;
        this.participant="";
        this.left=participantLimit;
    }

    // Getters
    public String getParticipant() {
        return participant;
    }
    public  int getRatingNum() {return  this.ratingNum;}
    public  int getRatingSum(){return  ratingSum;};
    public  int getLeft(){
        return left;
    }
    public int getParticipantLimit() {
        return participantLimit;
    }

    public String getDescription() {
        return description;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
    public String getCommentlist() {
        return commentlist;
    }

    // Setters
    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
    }
    public  void setRatingNum(int x){
        this.ratingSum=x;
    }

    public void setLeft(int x){
        left=x;
    }
    public  void setCommentlist(String commentlist){
        this.commentlist = commentlist;
    }
    public  void setRatingSum(int sum){
        this.ratingSum=sum;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int EventID) {
        this.EventID = EventID;
    }
}