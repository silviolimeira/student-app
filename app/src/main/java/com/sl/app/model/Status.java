package com.sl.app.model;

public class Status {

    private String name;
    private String title;

    public Status() {
    }

    public Status(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return title;
    }
}
