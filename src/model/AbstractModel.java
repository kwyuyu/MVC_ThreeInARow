package model;


import model.Utils.Player;

public interface AbstractModel {

    void takeOneMove();
    int getMoveLeft();
    void update(int row, int col, Player player);
    boolean checkIsWin();
    void resetGame();
}
