package com.itglance.springboot.web.model;

import javax.validation.constraints.Size;
import java.util.Date;

public class Todo {
    private int id;
    private String user;


    private String desc;

    public Todo() {
    }

    private Date targeDate;
    private boolean isDone;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTargeDate(Date targeDate) {
        this.targeDate = targeDate;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getDesc() {
        return desc;
    }

    public Date getTargeDate() {
        return targeDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public Todo(int id, String user, String desc, Date targeDate, boolean isDone) {
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.targeDate = targeDate;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", desc='" + desc + '\'' +
                ", targeDate=" + targeDate +
                ", isDone=" + isDone +
                '}';
    }
}
