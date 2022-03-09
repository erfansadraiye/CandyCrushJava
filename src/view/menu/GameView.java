package view.menu;

import controller.GameController;
import controller.RegisterController;
import model.User;
import model.boosters.BoosterType;
import model.game.Coordinate;
import model.game.Direction;
import model.game.Game;
import view.ConsoleCommands;

import java.util.regex.Matcher;

public class GameView extends ViewMenu {
    public void run(String input) {
        Matcher matcher;
        if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_CURRENT_MENU, input)) != null) {
            showCurrentMenu();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SWIPE, input)) != null) {
            swipe(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.ACTIVE_LOLLIPOP_HAMMER, input)) != null) {
            activeLollipop(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.ACTIVE_COLOUR_BOMB_BRUSH, input)) != null) {
            activeColourBombBrush(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.ACTIVE_WRAPPED_BRUSH, input)) != null) {
            activeWrappedBrush(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.ACTIVE_STRIPED_BRUSH, input)) != null) {
            activeStripedBrush(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.ACTIVE_FREE_SWITCH, input)) != null) {
            activeFreeSwitch(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.ACTIVE_EXTRA_MOVES, input)) != null) {
            activeExtraMoves(matcher);
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_BOARD, input)) != null) {
            showBoard();
        } else if ((matcher = ConsoleCommands.getMatcher(ConsoleCommands.SHOW_BOOSTERS, input)) != null) {
            showBoosters();
        } else {
            System.out.println("invalid command");
        }
    }

    void swipe(Matcher matcher) {
        try {
            int x = Integer.parseInt(matcher.group("x"));
            int y = Integer.parseInt(matcher.group("y"));
            Coordinate coordinate = new Coordinate(x, y);
            String direction = matcher.group("direction");
            GameController.getInstance().swipeCell(coordinate, direction, false);
            System.out.println("swipe cell successful");
            GameController.getInstance().doesGameContinue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    Coordinate getCoordinateByMatcher(Matcher matcher) {
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        return new Coordinate(x, y);
    }

    void activeLollipop(Matcher matcher) {
        try {
            Coordinate coordinate = getCoordinateByMatcher(matcher);
            GameController.getInstance().activeLollipop(coordinate);
            System.out.println("lollipop hammer has activated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void activeColourBombBrush(Matcher matcher) {
        try {
            Coordinate coordinate = getCoordinateByMatcher(matcher);
            GameController.getInstance().activateColourBombBrush(coordinate);
            System.out.println("colour bomb brush has activated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void activeWrappedBrush(Matcher matcher) {
        try {
            Coordinate coordinate = getCoordinateByMatcher(matcher);
            GameController.getInstance().activateWrappedBrush(coordinate);
            System.out.println("wrapped bomb brush has activated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void activeStripedBrush(Matcher matcher) {
        try {
            Coordinate coordinate = getCoordinateByMatcher(matcher);
            Direction direction;
            if (matcher.group("direction").equals("v"))
                direction = Direction.VERTICAL;
            else
                direction = Direction.HORIZONTAL;
            GameController.getInstance().activateStripedBrush(coordinate, direction);
            System.out.println("striped bomb brush has activated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void activeFreeSwitch(Matcher matcher) {
        try {
            Coordinate coordinate = getCoordinateByMatcher(matcher);
            String direction = matcher.group("direction");
            GameController.getInstance().activateFreeSwitch(coordinate, direction);
            System.out.println("free switch has activated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void activeExtraMoves(Matcher matcher) {
        try {
            GameController.getInstance().activateExtraMove();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void showBoard() {
        try {
            System.out.println(GameController.getInstance().toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void showBoosters() {
        User onlineUser = RegisterController.getInstance().getOnlineUser();
        System.out.println("Lollipop Hammer : " + onlineUser.getCountLollipopHammer());
        System.out.println("Colour Bomb : " + onlineUser.getCountColourBomb());
        System.out.println("Extra Moves : " + onlineUser.getCountExtraMoves());
        System.out.println("Free Switch : " + onlineUser.getCountFreeSwitch());
        System.out.println("Striped Brush : " + onlineUser.getCountStripedBrush());
    }

}
