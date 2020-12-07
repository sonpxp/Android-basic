package com.sonmob.androidfinal.model;

public class Users {
    private String email;
    private String password;

    public Users() {
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return  "Email:    " + email + "\n" +
                "Pass :    " + "..." + "\n";
    }
}
