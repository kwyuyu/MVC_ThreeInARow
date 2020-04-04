package model;

import model.Utils.Player;

public interface AbstractModel {

    Player getCurrentPlayer();
    int takeOneMove();
    Player switchPlayer();
    void update(int row, int col);
    boolean checkIsWin();
    void resetGame();
}
