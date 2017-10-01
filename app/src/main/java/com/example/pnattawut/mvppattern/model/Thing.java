package com.example.pnattawut.mvppattern.model;

/**
 * Created by PNattawut on 01-Oct-17.
 */

public class Thing {
    private int markInt;
    private String name;
    private String form;

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

    @Override
    public String toString() {
        return "Thing{" +
                "markInt=" + markInt +
                ", name='" + name + '\'' +
                ", form='" + form + '\'' +
                '}';
    }
}
