package controller;

public class RegisterController {
    protected static RegisterController instance;

    private RegisterController() {
    }

    public static RegisterController getInstance() {
        if (instance == null)
            instance = new RegisterController();
        return instance;
    }

    public void createUser(String username, String password, String nickname) {
        //TODO
    }

    public void loginUser(String username, String password) {
        //TODO
    }
}
