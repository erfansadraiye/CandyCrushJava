package controller;

import model.User;
import model.boosters.BoosterType;
import model.candies.*;
import model.combinations.CellCondition;
import model.combinations.Combination;
import model.combinations.CombinationFinder;
import model.combinations.NormalCombination;
import model.game.*;
import view.HandleRequestType;
import view.Menu;

import java.util.LinkedList;
import java.util.Queue;

public class GameController {
    private static GameController instance = null;
    private Game game;

    private GameController() {
    }

    public void startNewGame(int seed, int moves) {
        this.game = new Game(seed, moves);
        HandleRequestType.currentMenu = Menu.GAME_MENU;
    }


    public void swipeCell(Coordinate coordinate, String direction, boolean forceToSwipe) throws Exception {
        if (!coordinate.isValid(game.getBoard().getSize()))
            throw new Exception("invalid cell");
        if (!coordinate.getAdjacent(direction).isValid(game.getBoard().getSize()))
            throw new Exception("invalid destination");
        Cell first = game.getCellByCoordinate(coordinate);
        Cell second = game.getCellByCoordinate(coordinate.getAdjacent(direction));
        Combination combination = CombinationFinder.Find(first, second);
        Candy firstCandy = (Candy) first.getCandy().clone();
        Candy secondCandy = (Candy) second.getCandy().clone();
        game.getBoard().setCandy(first.getCoordinate(), secondCandy);
        game.getBoard().setCandy(second.getCoordinate(), firstCandy);
        if (!forceToSwipe && !eatCandies(combination.getCellCondition(game), 1)) {
            game.getBoard().setCandy(first.getCoordinate(), firstCandy);
            game.getBoard().setCandy(second.getCoordinate(), secondCandy);
            throw new Exception("invalid move");
        }
        if (!forceToSwipe)
            game.decreaseCountMoves();
    }

    public boolean eatCandies(CellCondition condition, int chainCount) {
        int size = game.getBoard().getSize();
        boolean[][] mark = new boolean[size][size];
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (condition.canExplodes(game.getCellByCoordinate(new Coordinate(i, j)))) {
                    queue.add(new Coordinate(i, j));
                    mark[i][j] = true;
                }

        if (queue.isEmpty())
            return false;
        while (!queue.isEmpty()) { // TODO: felan oon khoone avvali ha ham explode mishan
            Coordinate coordinate = queue.poll();
            CellCondition cellCondition = game.getCellByCoordinate(coordinate).getExplodeCondition();
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    if (!mark[i][j] && cellCondition.canExplodes(game.getCellByCoordinate(new Coordinate(i, j)))) {
                        queue.add(new Coordinate(i, j));
                        mark[i][j] = true;
                    }
        }
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (mark[i][j]) {
                    game.increaseScore(chainCount * 60);
                    game.getBoard().setCandy(new Coordinate(i, j), null);
                }
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                if (!mark[i][j]) {
                    Coordinate coordinate = new Coordinate(i, j);
                    Cell cell = game.getCellByCoordinate(coordinate);
                    Candy candy = cell.getCandy();
                    cell.setCandy(null);
                    for (int k = size - 1; k >= i; k--) {
                        if (game.getCellByCoordinate(new Coordinate(k, j)).getCandy() == null) {
                            game.getCellByCoordinate(new Coordinate(k, j)).setCandy(candy);
                            break;
                        }
                    }
                }
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                Coordinate coordinate = new Coordinate(i, j);
                if (game.getCellByCoordinate(coordinate).getCandy() == null) {
                    Color color = Color.getColorByNumber(game.getBoard().getFunction().nextInt());
                    game.getBoard().setCandy(coordinate, new Candy(color));
                }
            }
        }
        eatCandies(new NormalCombination().getCellCondition(game), chainCount + 1);
        return true;
    }

    public void activeLollipop(Coordinate coordinate) throws Exception {
        if (!coordinate.isValid(game.getBoard().getSize()))
            throw new Exception("invalid cell");
        if (RegisterController.getInstance().getOnlineUser().getCountLollipopHammer() == 0)
            throw new Exception("not enough lollipop hammer");
        RegisterController.getInstance().getOnlineUser().decreaseCountLollipopHammer();
        Cell cell = game.getCellByCoordinate(coordinate);
        eatCandies(cell.getExplodeCondition(), 1);
    }

    public void activateColourBombBrush(Coordinate coordinate) throws Exception {
        if (!coordinate.isValid(game.getBoard().getSize()))
            throw new Exception("invalid cell");
        if (RegisterController.getInstance().getOnlineUser().getCountColourBomb() == 0)
            throw new Exception("not enough colour bomb brush");
        Cell cell = game.getCellByCoordinate(coordinate);
        if (cell.getCandy() instanceof ColourBomb)
            throw new Exception("can't brush a bomb");
        game.getBoard().setCandy(coordinate, new ColourBomb());
        RegisterController.getInstance().getOnlineUser().decreaseCountColourBomb();
    }

    public void activateWrappedBrush(Coordinate coordinate) throws Exception {
        if (!coordinate.isValid(game.getBoard().getSize()))
            throw new Exception("invalid cell");
        if (RegisterController.getInstance().getOnlineUser().getCountWrappedBrush() == 0)
            throw new Exception("not enough wrapped brush");
        Cell cell = game.getCellByCoordinate(coordinate);
        if (cell.getCandy() instanceof ColourBomb)
            throw new Exception("can't brush a bomb");
        if (cell.getCandy() instanceof WrappedCandy)
            throw new Exception("this is already a wrapped candy");
        RegisterController.getInstance().getOnlineUser().decreaseCountWrappedBrush();
        game.getBoard().setCandy(coordinate, new WrappedCandy(cell.getCandy().getColor()));
    }

    public void activateStripedBrush(Coordinate coordinate, Direction direction) throws Exception {
        if (!coordinate.isValid(game.getBoard().getSize()))
            throw new Exception("invalid cell");
        if (RegisterController.getInstance().getOnlineUser().getCountStripedBrush() == 0)
            throw new Exception("not enough striped brush");
        Cell cell = game.getCellByCoordinate(coordinate);
        if (cell.getCandy() instanceof ColourBomb)
            throw new Exception("can't brush a bomb");
        if (cell.getCandy() instanceof StripedCandy)
            throw new Exception("this is already a striped candy");
        RegisterController.getInstance().getOnlineUser().decreaseCountStripedBrush();
        game.getBoard().setCandy(coordinate, new StripedCandy(cell.getCandy().getColor(), direction));
    }

    public void activateFreeSwitch(Coordinate coordinate, String direction) throws Exception {
        if (!coordinate.isValid(game.getBoard().getSize()))
            throw new Exception("invalid cell");
        if (!coordinate.getAdjacent(direction).isValid(game.getBoard().getSize()))
            throw new Exception("invalid destination");
        if (RegisterController.getInstance().getOnlineUser().getCountFreeSwitch() == 0)
            throw new Exception("not enough free switch");
        swipeCell(coordinate, direction, true);
    }

    public void activateExtraMove() throws Exception {
        if (RegisterController.getInstance().getOnlineUser().getCountExtraMoves() == 0)
            throw new Exception("not enough extra moves");
        game.increaseCountMoves(5);
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    @Override
    public String toString() {
        return game.toString();
    }

    public void doesGameContinue() throws Exception {
        if (game.getCountMoves() > 0)
            return;
        User player = RegisterController.getInstance().getOnlineUser();
        player.setHighScore(game.getScore());
        player.increaseMoney(game.getScore() / 10);
        HandleRequestType.currentMenu  = Menu.MAIN_MENU;
        throw new Exception("game has ended. your score is " + game.getScore());
    }
}
