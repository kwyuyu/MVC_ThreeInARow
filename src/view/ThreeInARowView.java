package view;

import model.Utils.Player;
import view.Utils.*;
import view.Utils.TextArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThreeInARowView implements AbstractView {

    private int size;

    private BlockButton[][] blocks;
    private ResetButton resetButton = new ResetButtonSwing("Reset");

    private BoardPanel game;
    private BoardFrame gui = new BoardFrameSwing();

    private TextArea playerTurn = new TextAreaSwing();


    public ThreeInARowView(int size) {
        this.size = size;
        this.blocks = new BlockButton[this.size][this.size];
        this.gui.setFrameSize(100 * this.size, 100 * this.size + 30);
        this.gui.setResizeable(true);

        BoardPanel gamePanel = new BoardPanelSwing(new FlowLayout());
        this.game = new BoardPanelSwing(new GridLayout(this.size, this.size));
        gamePanel.add(this.game, BorderLayout.CENTER);

        BoardPanel options = new BoardPanelSwing(new FlowLayout());
        options.add(this.resetButton);

        BoardPanel messages = new BoardPanelSwing(new FlowLayout());
        messages.setBackground(Color.white);

        this.gui.add(gamePanel, BorderLayout.NORTH);
        this.gui.add(options, BorderLayout.CENTER);
        this.gui.add(messages, BorderLayout.SOUTH);

        messages.add(this.playerTurn);
        this.playerTurn.setTextArea("Player 1 to play 'O'");

        this.blocksInitialize();
    }

    private void blocksInitialize() {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.blocks[row][col] = new BlockButtonSwing(row, col);
                this.blocks[row][col].setButtonSize(75, 75);
                this.game.add(this.blocks[row][col].getBlockButton());
            }
        }
    }



    @Override
    public BoardFrame getGui() {
        return this.gui;
    }

    @Override
    public BlockButton getBlockButton(int row, int col) {
        return this.blocks[row][col].getBlockButton();
    }

    @Override
    public BlockButton getBlockButton(ActionEvent e) {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (this.blocks[row][col].isEqualButton(e)) {
                    return this.blocks[row][col].getBlockButton();
                }
            }
        }
        return null;
    }

    @Override
    public void update(int row, int col, Player player) {
        this.blocks[row][col].setButtonText(player.getMarker());
        this.blocks[row][col].setButtonEnabled(false);
    }

    @Override
    public void resetGame() {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.blocks[row][col].reset();
            }
        }

        this.playerTurn.setTextArea("Player 1 to play 'O'");
    }

    @Override
    public String getPlayerTurnText() {
        return this.playerTurn.getText();
    }

    @Override
    public void setPlayerTurnText(String text) {
        this.playerTurn.setTextArea(text);
    }

    @Override
    public void endGame() {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.blocks[row][col].setButtonEnabled(false);
            }
        }
    }

    @Override
    public void addResetButtonListener(ActionListener listener) {
        this.resetButton.addActionListener(listener);
    }

    @Override
    public void addBlockButtonListener(int row, int col, ActionListener listener) {
        this.blocks[row][col].addActionListener(listener);
    }
}
