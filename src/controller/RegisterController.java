package controller;

import model.User;
import view.HandleRequestType;
import view.Menu;

import java.util.ArrayList;
import java.util.HashMap;

public class RegisterController {
    private static RegisterController instance;
    private HashMap<String, String> userPass;
    private ArrayList<User> allUsers;
    private User onlineUser;
    private final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}\\[\\]:;<>,?/~_+\\-=|]).{8,32}$";
    private RegisterController() {
        userPass = new HashMap<>();
        allUsers = new ArrayList<>();
    }

    public static RegisterController getInstance() {
        if (instance == null)
            instance = new RegisterController();
        return instance;
    }

    public static User getUserByUsername(String username) {
        if (getInstance().userPass.containsKey(username)) {
            for (User user : getInstance().allUsers) {
                if (user.getUsername().equals(username))
                    return user;
            }
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public HashMap<String, String> getUserPass() {
        return userPass;
    }

    public void createUser(String username, String password, String nickname) throws Exception {
        if (!username.matches("\\w+"))
            throw new Exception("username's format is invalid!");
        if (!nickname.matches("[a-zA-Z ]+"))
            throw new Exception("nickname's format is invalid!");
        if (!password.matches(REGEX_PASSWORD))
            throw new Exception("password is weak!");
        if (userPass.containsKey(username))
            throw new Exception("username already exists!");
        User newUser = new User(username, password, nickname);
        userPass.put(username, password);
        allUsers.add(newUser);
    }

    public void loginUser(String username, String password) throws Exception {
        if (!username.matches("\\w+"))
            throw new Exception("username's format is invalid!");
        if (!userPass.containsKey(username))
            throw new Exception("username doesn't exist!");
        if (!userPass.get(username).equals(password))
            throw new Exception("incorrect password!");
        onlineUser = RegisterController.getUserByUsername(username);
        HandleRequestType.currentMenu = Menu.MAIN_MENU;
    }

    public void logout() {
        onlineUser = null;
        HandleRequestType.currentMenu = Menu.REGISTER_MENU;
    }

    public void changePassword(String oldPassword, String newPassword) throws Exception {
        if (!oldPassword.equals(onlineUser.getPassword()))
            throw new Exception("password is incorrect!");
        if (!newPassword.matches(REGEX_PASSWORD))
            throw new Exception("password is weak!");
        onlineUser.setPassword(newPassword);
        userPass.put(onlineUser.getUsername(), newPassword);
    }

    public User getOnlineUser() {
        return onlineUser;
    }

    public String listOfUsers() {
        StringBuilder output = new StringBuilder();
        output.append(allUsers.size());
        output.append(" users have registered!");
        for (int i = 0; i < allUsers.size(); i++) {
            output.append('\n').append(i+1);
            output.append(" - ");
            output.append(allUsers.get(i).getNickname());
        }
        return output.toString();
    }

    public void deleteAccount(String password) throws Exception {
        if (!onlineUser.getPassword().equals(password))
            throw new Exception("incorrect password!");
        allUsers.remove(onlineUser);
        userPass.remove(onlineUser.getUsername());
        onlineUser = null;
        HandleRequestType.currentMenu = Menu.REGISTER_MENU;
    }
}
