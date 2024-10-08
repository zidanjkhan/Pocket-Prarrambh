package com.example.prarrambh;

public class eventData {
    String name, contact, disc;
    int img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public eventData(String name, String contact, String disc, int img) {
        this.name = name;
        this.contact = contact;
        this.disc = disc;
        this.img = img;
    }
}
