package view.Utils;

import javax.swing.*;
import java.awt.*;

public class BlockButton extends JButton {

    private int row;
    private int col;

    public BlockButton(int row, int col) {
        this.row = row;
        this.col = col;
        this.setText("");
        this.setEnabled(true);
    }

    public BlockButton(String buttonText) {
        this.setText(buttonText);
        this.setEnabled(true);
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public BlockButton getBlockButton() {
        return this;
    }

    public void setButtonSize(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
    }

    public void setButtonText(String text) {
        this.setText(text);
    }

    public void setButtonEnabled(boolean bool) {
        this.setEnabled(bool);
    }

    public void reset() {
        this.setText("");
        this.setEnabled(true);
    }


}
