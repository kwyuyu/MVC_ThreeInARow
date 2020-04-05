package view.Utils;

import javax.swing.*;

public class TextAreaSwing extends TextArea {

    private JTextArea textArea;

    public TextAreaSwing() {
        this.textArea = new JTextArea();
    }

    public JTextArea getTextArea() {
        return this.textArea;
    }

    @Override
    public void setTextArea(String text) {
        this.textArea.setText(text);
    }

    @Override
    public String getText() {
        return this.textArea.getText();
    }
}
