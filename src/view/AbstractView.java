package view;

import model.Utils.Player;

import java.awt.event.ActionListener;

public interface AbstractView {

    void display();
    void update(int row, int col, Player player);
    void resetGame();
    void switchPlayer(Player player);
    void winGameView(Player player);
    void drawGameView();

    void addResetButtonListener(ActionListener listener);
    void addBlockButtonListener(int row, int col, ActionListener listener);

}
