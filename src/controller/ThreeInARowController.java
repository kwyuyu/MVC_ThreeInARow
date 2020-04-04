package controller;

import model.ThreeInARowModel;
import model.Utils.Player;
import view.ThreeInARowView;
import view.Utils.BlockButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreeInARowController implements AbstractController {

    private int size;
    private ThreeInARowView view;
    private ThreeInARowModel model;

    public ThreeInARowController(int size, ThreeInARowView view, ThreeInARowModel model) {
        this.size = size;
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
        this.view.display();
    }

    @Override
    public void move(BlockButton blockButton) {
        int moveLeft = this.model.takeOneMove();
        int row = blockButton.getRow();
        int col = blockButton.getCol();
        Player currentPlayer = this.model.getCurrentPlayer();

        this.model.update(row, col);
        this.view.update(row, col, currentPlayer);

        if (this.model.checkIsWin()) {
            // win
            this.view.winGameView(currentPlayer);
        }
        else if (moveLeft == 0) {
            // draw
            this.view.drawGameView();
        }
        else {
            this.view.switchPlayer(this.model.switchPlayer());
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetGame();
            model.resetGame();
        }
    }

    private class BlockListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            move((BlockButton) e.getSource());
        }
    }
}
