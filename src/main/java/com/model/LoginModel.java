package main.java.com.model;

import java.util.List;
import java.util.Objects;

public class LoginModel {

    private Integer userID;
    private String username;
    private String psword;
    private List<String> roles;

    public LoginModel(String username, String psword) {
        this.username = username;
        this.psword = psword;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsword() {
        return psword;
    }

    public void setPsword(String psword) {
        this.psword = psword;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginModel that = (LoginModel) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(psword, that.psword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, psword);
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", psword='" + psword + '\'' +
                ", roles=" + roles +
                '}';
    }
}
