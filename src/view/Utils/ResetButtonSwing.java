package view.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ResetButtonSwing extends ResetButton {

    private JButton button;

    public ResetButtonSwing(String buttonText) {
        this.button = new JButton(buttonText);
    }

    public JButton getResetButtonSwing() {
        return this.button;
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
