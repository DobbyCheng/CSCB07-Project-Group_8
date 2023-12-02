package com.example.b07project.adminop;

public class ViewAnnouncementModel {

    private String admin;
    private String title;
    private String content;
    private String id;
    private String date;

    public ViewAnnouncementModel(String admin, String title, String content, String id,String date) {
        this.admin = admin;
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getAdmin() {
        return "posted by "+admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getTitle() {
        return "title: "+title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return "content: "+content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return "#"+id;
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

    @Override
    public String toString() {
        return "Announcement{" +
                "admin='" + admin + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
