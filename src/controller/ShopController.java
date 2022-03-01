package controller;

public class ShopController {
    private static ShopController instance;

    private ShopController() {

    }

    public static ShopController getInstance() {
        if (instance == null)
            instance = new ShopController();
        return instance;
    }

    public void buyLollipopHammer(int count) throws Exception {
        //TODO check money and count>0
    }

    public void buyColourBomb(int count) throws Exception {
        //TODO
    }

    public void buyExtraMoves(int count) throws Exception {
        //TODO
    }

    public void buyFreeSwitch(int count) throws Exception {
        //TODO
    }

    public void buyStripedBrush(int count) throws Exception {
        //TODO
    }

}
