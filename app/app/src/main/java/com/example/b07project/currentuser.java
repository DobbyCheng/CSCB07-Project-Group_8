package com.example.b07project;

public class currentuser {
    static String name;
    currentuser(){
        name=null;
    }
    public void  changename(String newname) {
        name=newname;
    }
    public String getName(){
        return name;
    }
    public void loggingout(){
        name=null;
    }

}
