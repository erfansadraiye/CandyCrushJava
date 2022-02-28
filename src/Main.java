import controller.GameController;
import view.HandleRequestType;

public class Main {
    public static void main(String[] args) throws Exception {
        GameController.getInstance();
        HandleRequestType handleRequestType = new HandleRequestType();
        handleRequestType.start();
    }
}
