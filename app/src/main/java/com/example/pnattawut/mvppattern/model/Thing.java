package com.example.pnattawut.mvppattern.model;

/**
 * Created by PNattawut on 01-Oct-17.
 */

public class Thing {

    private int markInt;
    private String name;
    private String type;
    private String form;
    private String url;

    public Thing() {
    }

    public Thing(int markInt, String name, String type, String form, String url) {
        this.markInt = markInt;
        this.name = name;
        this.type = type;
        this.form = form;
        this.url = url;
    }


    public int getMarkInt() {
        return markInt;
    }

    public void setMarkInt(int markInt) {
        this.markInt = markInt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "Thing{" +
                "markInt=" + markInt +
                ", name='" + name + '\'' +
                ", form='" + form + '\'' +
                '}';
    }

}
