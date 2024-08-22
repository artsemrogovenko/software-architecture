package ru.geekbrains.lesson6.database;

import java.util.Date;

public class NotesRecord {

    private static int counter = 10000;
    private int id;
    private int userid;
    private String title;
    private String details;
    private Date creationDate;

    public int getId() {
        return id;
    }
    public int getUserId() {  return userid;  }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Date getCreationDate() {  return creationDate;  }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public NotesRecord(String title, String details) {
        this.title = title;
        this.details = details;
        id = ++counter;
    }


}
