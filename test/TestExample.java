import controller.AbstractController;
import controller.ThreeInARowController;
import model.AbstractModel;
import model.ThreeInARowModel;
import model.Utils.Player;
import org.junit.jupiter.api.*;
import view.AbstractView;
import view.ThreeInARowView;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {

    private AbstractController controller;
    private AbstractView view;
    private AbstractModel model;
    private int size = 3;

    @BeforeEach
    public void setUp() {
        this.model = new ThreeInARowModel(this.size);
        this.view = new ThreeInARowView(this.size);
        this.controller = new ThreeInARowController(this.size, this.view, this.model);
    }

    @AfterEach
    public void tearDown() {
	    this.controller = null;
	    this.view = null;
	    this.model = null;
    }

    @Test
    @DisplayName("Test new game")
    public void testNewGame() {
        assertEquals(Player.P1, this.controller.getCurrentPlayer());
        assertEquals(9, this.model.getMoveLeft());
    }

    @Test
    @DisplayName("Test switch player")
    public void testSwitchPlayer() {
	    assertEquals(this.controller.getCurrentPlayer(), Player.P1);

	    this.controller.move(this.view.getBlockButton(2, 0));

	    assertEquals(this.controller.getCurrentPlayer(), Player.P2);
    }

    @Nested
    @DisplayName("Test row condition")
    class TestRowCondition {

        @Test
        @DisplayName("Test row condition win for P1")
        public void testRowConditionWinForP1() {
            ((ThreeInARowController)controller).debug = true;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    controller.move(view.getBlockButton(row, col));
                }
                assertEquals(view.getPlayerTurnText(), controller.getWinMessage());
            }
        }

        @Test
        @DisplayName("Test row condition win for P2")
        public void testRowConditionWinForP2() {
            ((ThreeInARowController)controller).debug = true;
            controller.switchPlayer();

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    controller.move(view.getBlockButton(row, col));
                }
                assertEquals(view.getPlayerTurnText(), controller.getWinMessage());
            }
        }
    }


    @Nested
    @DisplayName("Test column condition")
    class TestColumnCondition {

        @Test
        @DisplayName("Test column condition win for P1")
        public void testColConditionWinForP1() {
            ((ThreeInARowController)controller).debug = true;

            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    controller.move(view.getBlockButton(row, col));
                }
                assertEquals(view.getPlayerTurnText(), controller.getWinMessage());
            }
        }

        @Test
        @DisplayName("Test column condition win for P2")
        public void testColConditionWinForP2() {
            ((ThreeInARowController)controller).debug = true;
            controller.switchPlayer();

            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    controller.move(view.getBlockButton(row, col));
                }
                assertEquals(view.getPlayerTurnText(), controller.getWinMessage());
            }
        }
    }


    @Nested
    @DisplayName("Test diagonal condition")
    class TestDiagCondition {

        @Test
        @DisplayName("Test diagonal condition win for P1")
        public void testDiagConditionWinForP1() {
            ((ThreeInARowController)controller).debug = true;

            for (int col = 0; col < size; col++) {
                controller.move(view.getBlockButton(col, col));
            }
            assertEquals(view.getPlayerTurnText(), controller.getWinMessage());
        }

        @Test
        @DisplayName("Test diagonal condition win for P2")
        public void testDiagConditionWinForP2() {
            ((ThreeInARowController)controller).debug = true;
            controller.switchPlayer();

            for (int col = 0; col < size; col++) {
                controller.move(view.getBlockButton(col, col));
            }
            assertEquals(view.getPlayerTurnText(), controller.getWinMessage());
        }
    }


    @Nested
    @DisplayName("Test anti-diagonal condition")
    class TestAntiDiagCondition {

        @Test
        @DisplayName("Test anti-diagonal condition win for P1")
        public void testAntiDiagConditionWinForP1() {
            ((ThreeInARowController)controller).debug = true;

            for (int col = 0; col < size; col++) {
                controller.move(view.getBlockButton(col, size - col - 1));
            }
            assertEquals(view.getPlayerTurnText(), controller.getWinMessage());
        }

        @Test
        @DisplayName("Test anti-diagonal condition win for P2")
        public void testAntiDiagConditionWinForP2() {
            ((ThreeInARowController)controller).debug = true;
            controller.switchPlayer();

            for (int col = 0; col < size; col++) {
                controller.move(view.getBlockButton(col, size - col - 1));
            }
            assertEquals(view.getPlayerTurnText(), controller.getWinMessage());
        }
    }


}







