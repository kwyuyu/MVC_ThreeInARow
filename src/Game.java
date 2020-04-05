import controller.AbstractController;
import controller.ThreeInARowController;
import model.AbstractModel;
import model.ThreeInARowModel;
import view.AbstractView;
import view.ThreeInARowView;

public class Game {

    public static void main(String[] args) {
        int size = 3;

        AbstractModel model = new ThreeInARowModel(size);
        AbstractView view = new ThreeInARowView(size);
        AbstractController controller = new ThreeInARowController(size, view, model);

        controller.run();
    }
}
