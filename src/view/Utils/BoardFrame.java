package view.Utils;

import javax.swing.*;
import java.awt.*;

public class BoardFrame extends JFrame {

    public BoardFrame() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
    }

    public void setFrameSize(int width, int height) {
        this.setSize(new Dimension(width, height));
    }

}
