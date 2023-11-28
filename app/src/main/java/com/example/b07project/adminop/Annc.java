package com.example.b07project.adminop;

public class Annc {
    private String admin;  // 建议字段名改为 "admin"
    private String title;
    private String content;
    private String id;
    String date;

    public Annc(String admin, String title, String content, String id,String date) {
        this.admin = admin;
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // Getter 和 Setter 方法（根据需要添加）
    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Annc{" +
                "admin='" + admin + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
