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

    private RegisterController() {
        userPass = new HashMap<>();
        allUsers = new ArrayList<>();
    }

    public static RegisterController getInstance() {
        if (instance == null)
            instance = new RegisterController();
        return instance;
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public HashMap<String, String> getUserPass() {
        return userPass;
    }

    public void createUser(String username, String password, String nickname) throws Exception {
        if (userPass.containsKey(username))
            throw new Exception("username exists!");
        User newUser = new User(username, password, nickname);
        userPass.put(username, password);
        allUsers.add(newUser);
    }

    public void loginUser(String username, String password) throws Exception {
        if (!userPass.containsKey(username))
            throw new Exception("username doesn't exist!");
        if (!userPass.get(username).equals(password))
            throw new Exception("password is incorrect!");
        onlineUser = RegisterController.getUserByUsername(username);
        HandleRequestType.currentMenu = Menu.MAIN_MENU;
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

    public void logout() {
        onlineUser = null;
        HandleRequestType.currentMenu = Menu.REGISTER_MENU;
    }

    public void enterMenu(Menu menu) throws Exception {
        if (menu == null)
            throw new Exception("invalid command!");
        if (menu == Menu.MAIN_MENU || menu == Menu.REGISTER_MENU)
            throw new Exception("menu navigation is not possible");
        HandleRequestType.currentMenu = menu;
    }

    public User getOnlineUser() {
        return onlineUser;
    }
}
