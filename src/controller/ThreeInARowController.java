package controller;

import model.AbstractModel;
import model.Utils.Player;
import view.AbstractView;
import view.Utils.BlockButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreeInARowController implements AbstractController {

    private static final String DRAW_MESSAGE = "Game ends in a draw!";

    private int size;
    private Player currentPlayer;

    private AbstractView view;
    private AbstractModel model;

    public boolean debug = false;

    public ThreeInARowController(int size, AbstractView view, AbstractModel model) {
        this.size = size;
        this.currentPlayer = Player.P1;

        this.view = view;
        this.model = model;

        this.addResetButtonListener();
        this.addBlockButtonListener();
    }

    private void addResetButtonListener() {
        this.view.addResetButtonListener(new ResetButtonListener());

    }

    private void addBlockButtonListener() {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.view.addBlockButtonListener(row, col, new BlockListener());
            }
        }
    }


    @Override
    public void run() {
        this.view.getGui().setVisible(true);
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public void switchPlayer() {
        this.currentPlayer = this.currentPlayer == Player.P2 ? Player.P1 : Player.P2;
    }

    @Override
    public String getWinMessage() {
        return String.format("Player %d wins!", (this.currentPlayer.getId()));
    }

    @Override
    public String getNextPlayerMessage() {
        return String.format("'%s': Player %d", this.currentPlayer.getMarker(), this.currentPlayer.getId());
    }

    @Override
    public void move(BlockButton blockButton) {
        this.model.takeOneMove();
        int moveLeft = this.model.getMoveLeft();
        int row = blockButton.getRow();
        int col = blockButton.getCol();

        this.model.update(row, col, this.currentPlayer);
        this.view.update(row, col, this.currentPlayer);

        if (this.model.checkIsWin()) {
            // win
            this.view.endGame();
            this.view.setPlayerTurnText(this.getWinMessage());
        }
        else if (moveLeft == 0) {
            // draw
            this.view.endGame();
            this.view.setPlayerTurnText(DRAW_MESSAGE);
        }
        else {
            if (!this.debug) {
                this.switchPlayer();
            }
            this.view.setPlayerTurnText(this.getNextPlayerMessage());
        }
    }

    @Override
    public void resetGame() {
        this.view.resetGame();
        this.model.resetGame();
        this.currentPlayer = Player.P1;
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resetGame();
        }
    }

    private class BlockListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            move(view.getBlockButton(e));
        }
    }
}
