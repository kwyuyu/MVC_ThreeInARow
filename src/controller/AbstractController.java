package controller;

import model.Utils.Player;
import view.Utils.BlockButton;


public interface AbstractController {

    void run();
    Player getCurrentPlayer();
    void switchPlayer();
    String getWinMessage();
    String getNextPlayerMessage();
    void move(BlockButton blockButton);
    void resetGame();
}
