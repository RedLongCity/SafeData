package main.java.com.dao;

import main.java.com.model.LoginModel;

import java.util.HashMap;
import java.util.Map;

public class UsersData {

    private static UsersData ourInstance = new UsersData();

    public static UsersData getInstance() {
        return ourInstance;
    }

    private Map<Integer, LoginModel> data;

    private UsersData() {
        data = new HashMap<>();
    }

    public void addNewUser(LoginModel loginModel) {
        getData().put(loginModel.hashCode(), loginModel);
    }

    public LoginModel getLogin(LoginModel loginModel) {
        return getData().get(loginModel.hashCode());
    }


    public Map<Integer, LoginModel> getData() {
        return data;
    }

    public void setData(Map<Integer, LoginModel> data) {
        this.data = data;
    }
}
