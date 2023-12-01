package com.example.b07project.adminop;

public class ViewComplaintModel {
    private String topic;
    private String content;
    private String studentName;
    private String date;
    private String complaintId;

    public ViewComplaintModel(String topic, String content, String studentName, String date, String complaintId) {
        this.topic = topic;
        this.content = content;
        this.studentName = studentName;
        this.date = date;
        this.complaintId = complaintId;
    }

    // Getter methods
    public String getTopic() {
        return "topic: "+topic;
    }

    public String getContent() {
        return content;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDate() {
        return date;
    }

    public String getComplaintId() {
        return "#"+complaintId;
    }

    // Setter methods (if needed)

    // Other methods as needed

    // toString method
    @Override
    public String toString() {
        return "ViewComplaintModel{" +
                "studentName='" + studentName + '\'' +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", complaintId='" + complaintId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
