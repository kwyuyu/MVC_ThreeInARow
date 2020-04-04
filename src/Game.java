import controller.ThreeInARowController;
import model.ThreeInARowModel;
import view.ThreeInARowView;

public class Game {

    public static void main(String[] args) {
        int size = 3;

        ThreeInARowModel model = new ThreeInARowModel(size);
        ThreeInARowView view = new ThreeInARowView(size);
        ThreeInARowController controller = new ThreeInARowController(size, view, model);

        controller.run();
    }
}
