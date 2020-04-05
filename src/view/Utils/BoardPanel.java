package view.Utils;


import java.awt.*;

public abstract class BoardPanel {

    public abstract void add(BoardPanel boardPanel, String borderLayout);
    public abstract void add(ResetButton button);
    public abstract void add(BlockButton button);
    public abstract void add(TextArea textArea);
    public abstract void setBackground(Color color);

}
