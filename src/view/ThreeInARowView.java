package view;

import model.Utils.Player;
import view.Utils.BlockButton;
import view.Utils.BoardFrame;
import view.Utils.BoardPanel;
import view.Utils.TextArea;

import java.awt.*;
import java.awt.event.ActionListener;

public class ThreeInARowView implements AbstractView {

    private int size;

    private BlockButton[][] blocks;
    private BlockButton resetButton = new BlockButton("Reset");

    private BoardPanel game;
    private BoardFrame gui = new BoardFrame();

    private TextArea playerTurn = new TextArea();


    public ThreeInARowView(int size) {
        this.size = size;
        this.blocks = new BlockButton[this.size][this.size];
        this.gui.setSize(100 * this.size, 100 * this.size + 30);

        BoardPanel gamePanel = new BoardPanel(new FlowLayout());
        this.game = new BoardPanel(new GridLayout(this.size, this.size));
        gamePanel.add(this.game, BorderLayout.CENTER);

        BoardPanel options = new BoardPanel(new FlowLayout());
        options.add(this.resetButton);

        BoardPanel messages = new BoardPanel(new FlowLayout());
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
                this.blocks[row][col] = new BlockButton(row, col);
                this.blocks[row][col].setButtonSize(75, 75);
                this.game.add(this.blocks[row][col].getBlockButton());
            }
        }
    }


    @Override
    public void display() {
        this.gui.setVisible(true);
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
    public void switchPlayer(Player player) {
        this.playerTurn.setTextArea(String.format("'%s'L Player %d", player.getMarker(), player.getId()));
    }

    @Override
    public void winGameView(Player player) {
        this.playerTurn.setTextArea(String.format("Player %d wins!", (player.getId())));

        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.blocks[row][col].setButtonEnabled(false);
            }
        }
    }

    @Override
    public void drawGameView() {
        this.playerTurn.setTextArea("Game ends in a draw!");
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
