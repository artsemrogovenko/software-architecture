package ru.geekbrains.lesson6.domain;

import java.util.Date;

public class Note {

    {

    }
    //region Constructors

    public Note(int id, int userId, String title, String details, Date creationDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.creationDate = creationDate;
    }

    public Note(int id, String title, String details) {
        this.id = id;
        this.title = title;
        this.details = details;
    }


    //endregion

    //region Getters Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEditDate() {
        return editDate;
    }


    //endregion

    //region Fields
    private int id;
    private int userId;
    private String title;
    private String details;
    private Date creationDate;
    private Date editDate;

    //endregion

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                '}';
    }


}
