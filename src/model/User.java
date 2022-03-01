package model;

import controller.RegisterController;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private String nickname;

    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public static User getUserByUsername(String username) {
        ArrayList<User> allUsers = RegisterController.getInstance().getAllUsers();
        if (RegisterController.getInstance().getUserPass().containsKey(username)) {
            for (User user : allUsers) {
                if (user.getUsername().equals(username))
                    return user;
            }
        }
        return null;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

}
