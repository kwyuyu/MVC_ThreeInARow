package view.Utils;

import java.awt.event.ActionListener;

public abstract class Button {

    public Button getButton() {
        return this;
    }

    public abstract void setButtonSize(int width, int height);
    public abstract void setButtonText(String text);
    public abstract void setButtonEnabled(boolean bool);

    public abstract void addActionListener(ActionListener listener);

}
