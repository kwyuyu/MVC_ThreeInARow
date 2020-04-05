package view.Utils;


public abstract class BoardFrame {

    public abstract void setFrameSize(int width, int height);
    public abstract void setResizeable(boolean bool);
    public abstract void setVisible(boolean bool);
    public abstract void add(BoardPanel boardPanel, String borderLayout);

}
