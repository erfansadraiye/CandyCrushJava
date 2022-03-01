package controller;

import model.User;
import model.boosters.BoosterType;

public class ShopController {
    private static ShopController instance;

    private ShopController() {

    }

    public static ShopController getInstance() {
        if (instance == null)
            instance = new ShopController();
        return instance;
    }

    public void buyBooster(BoosterType boosterType, int count) throws Exception {
        if (boosterType == null)
            throw new Exception("booster doesn't exist");
        int cost = count * boosterType.getPrice();
        User onlineUser = RegisterController.getInstance().getOnlineUser();
        if (cost > onlineUser.getWallet())
            throw new Exception("not enough money!");
        onlineUser.decreaseMoney(cost);
        switch (boosterType) {
            case LOLLIPOP_HAMMER:
                onlineUser.increaseCountLollipopHammer(count);
                break;
            case COLOUR_BOMB_BRUSH:
                onlineUser.increaseCountColourBomb(count);
                break;
            case EXTRA_MOVES:
                onlineUser.increaseCountExtraMoves(count);
                break;
            case FREE_SWITCH:
                onlineUser.increaseCountFreeSwitch(count);
                break;
            case STRIPED_BRUSH:
                onlineUser.increaseCountStripedBrush(count);
                break;
            case WRAPPED_BRUSH:
                onlineUser.increaseCountWrappedBrush(count);
                break;
        }

    }


}
