package view;

import model.Utils.Player;
import view.Utils.BlockButton;
import view.Utils.BoardFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface AbstractView {

    BoardFrame getGui();
    BlockButton getBlockButton(int row, int col);
    BlockButton getBlockButton(ActionEvent e);
    void update(int row, int col, Player player);
    void resetGame();
    String getPlayerTurnText();
    void setPlayerTurnText(String text);
    void endGame();

    void addResetButtonListener(ActionListener listener);
    void addBlockButtonListener(int row, int col, ActionListener listener);

}
