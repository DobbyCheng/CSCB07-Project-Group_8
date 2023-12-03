package com.example.b07project.loginandregister;

public class Admin {
    private String name;
    private String password;

    // 构造函数
    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getter 和 Setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // toString 方法
    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
