package view.Utils;

import javax.swing.*;
import java.awt.*;

public class BoardFrameSwing extends BoardFrame {

    private JFrame frame;

    public BoardFrameSwing() {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void setFrameSize(int width, int height) {
        this.frame.setSize(new Dimension(width, height));
    }

    @Override
    public void setResizeable(boolean bool) {
        this.frame.setResizable(bool);
    }

    @Override
    public void setVisible(boolean bool) {
        this.frame.setVisible(bool);
    }

    @Override
    public void add(BoardPanel boardPanel, String borderLayout) {
        this.frame.add(((BoardPanelSwing)boardPanel).getBoardPanel(), borderLayout);
    }

}
