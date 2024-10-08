package com.example.prarrambh;

public class users {
    String username, contact, college, email, password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public users(String username, String college,String contact, String email, String password) {
        this.username = username;
        this.contact = contact;
        this.college = college;
        this.email = email;
        this.password = password;
    }
}
