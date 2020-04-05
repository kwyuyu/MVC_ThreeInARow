package view.Utils;


import java.awt.event.ActionEvent;

public abstract class BlockButton extends Button {

    private int row;
    private int col;

    public BlockButton(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public BlockButton getBlockButton()
    {
        return this;
    }

    public abstract boolean isEqualButton(ActionEvent e);
    public abstract void reset();

}
