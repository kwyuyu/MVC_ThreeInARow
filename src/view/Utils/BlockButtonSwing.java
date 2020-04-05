package view.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BlockButtonSwing extends BlockButton {

    private JButton button;

    public BlockButtonSwing(int row, int col) {
        super(row, col);
        this.button = new JButton();
        this.reset();
    }

    @Override
    public boolean isEqualButton(ActionEvent e) {
        return e.getSource() == this.button;
    }

    public JButton getBlockButtonSwing() {
        return this.button;
    }


    @Override
    public void reset() {
        this.button.setText("");
        this.button.setEnabled(true);
    }

    @Override
    public void setButtonSize(int width, int height) {
        this.button.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void setButtonText(String text) {
        this.button.setText(text);
    }

    @Override
    public void setButtonEnabled(boolean bool) {
        this.button.setEnabled(bool);
    }

    @Override
    public void addActionListener(ActionListener listener) {
        this.button.addActionListener(listener);
    }
}



