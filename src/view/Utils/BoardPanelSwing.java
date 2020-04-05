package view.Utils;

import javax.swing.*;
import java.awt.*;

public class BoardPanelSwing extends BoardPanel {

    private JPanel panel;

    public BoardPanelSwing(FlowLayout flowLayout) {
        this.panel = new JPanel(flowLayout);
    }

    public BoardPanelSwing(GridLayout gridLayout) {
        this.panel = new JPanel(gridLayout);
    }

    public JPanel getBoardPanel() {
        return this.panel;
    }

    @Override
    public void add(BoardPanel boardPanel, String borderLayout) {
        this.panel.add(((BoardPanelSwing)boardPanel).getBoardPanel(), borderLayout);
    }

    @Override
    public void add(ResetButton button) {
        this.panel.add(((ResetButtonSwing)button).getResetButtonSwing());
    }

    @Override
    public void add(BlockButton button) {
        this.panel.add(((BlockButtonSwing)button).getBlockButtonSwing());
    }

    @Override
    public void add(TextArea textArea) {
        this.panel.add(((TextAreaSwing)textArea).getTextArea());
    }

    @Override
    public void setBackground(Color color) {
        this.panel.setBackground(color);
    }
}
