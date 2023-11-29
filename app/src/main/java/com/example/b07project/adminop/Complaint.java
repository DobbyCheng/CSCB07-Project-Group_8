package com.example.b07project.adminop;

public class Complaint {
    String topic;
    String content;
    String name;
    String date;
    private String id;

    public Complaint(String topic, String content, String name,String date,String id) {
        this.topic = topic;
        this.content = content;
        this.name = name;
        this.date=date;
        this.id=id;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    // toString 方法（根据需要添加）
    @Override
    public String toString() {
        return "complaint{" +
                "student='" + name + '\'' +
                ", title='" + this.topic + '\'' +
                ", content='" + content + '\'' +
                ", id='" + this.id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}