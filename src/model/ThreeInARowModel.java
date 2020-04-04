package model;

import model.Utils.BlockData;
import model.Utils.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeInARowModel implements AbstractModel {

    private int size;
    private int moveLeft;
    private Player currentPlayer = Player.P1;
    private BlockData[][] blockData;

    private Map<Player, int[]> rowCache = new HashMap<>();
    private Map<Player, int[]> colCache = new HashMap<>();
    private Map<Player, Integer> diagCache = new HashMap<>();
    private Map<Player, Integer> antiDiagCache = new HashMap<>();

    private boolean someoneWin = false;

    public ThreeInARowModel(int size) {
        this.size = size;
        this.moveLeft = this.size * this.size;
        this.blockData = new BlockData[this.size][this.size];

        this.blockDataInitialize();
        this.cacheInitialize();

    }

    private void blockDataInitialize() {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.blockData[row][col] = new BlockData(row, col);
            }
        }
    }

    private void cacheInitialize() {
        this.rowCache.put(Player.P1, new int[this.size]);
        Arrays.fill(this.rowCache.get(Player.P1), 0);

        this.rowCache.put(Player.P2, new int[this.size]);
        Arrays.fill(this.rowCache.get(Player.P2), 0);

        this.colCache.put(Player.P1, new int[this.size]);
        Arrays.fill(this.colCache.get(Player.P1), 0);

        this.colCache.put(Player.P2, new int[this.size]);
        Arrays.fill(this.colCache.get(Player.P2), 0);

        this.diagCache.put(Player.P1, 0);
        this.diagCache.put(Player.P2, 0);

        this.antiDiagCache.put(Player.P1, 0);
        this.antiDiagCache.put(Player.P2, 0);
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public int takeOneMove() {
        return --this.moveLeft;
    }

    @Override
    public Player switchPlayer() {
        this.currentPlayer = this.currentPlayer == Player.P2 ? Player.P1 : Player.P2;
        return this.currentPlayer;
    }

    @Override
    public void update(int row, int col) {
        // diagonal
        if (row == col) {
            this.diagCache.put(this.currentPlayer, this.diagCache.get(this.currentPlayer) + 1);
        }

        // anti-diagonal
        if (row + col + 1 == this.size) {
            this.antiDiagCache.put(this.currentPlayer, this.antiDiagCache.get(this.currentPlayer) + 1);
        }

        // row
        this.rowCache.get(this.currentPlayer)[row] += 1;

        // col
        this.colCache.get(this.currentPlayer)[col] += 1;

        if (this.diagCache.get(this.currentPlayer) == this.size ||
            this.antiDiagCache.get(this.currentPlayer) == this.size ||
            this.rowCache.get(this.currentPlayer)[row] == this.size ||
            this.colCache.get(this.currentPlayer)[col] == this.size) {
            this.someoneWin = true;
        }
    }

    @Override
    public boolean checkIsWin() {
        return this.someoneWin;
    }

    @Override
    public void resetGame() {
        this.currentPlayer = Player.P1;
        this.moveLeft = this.size * this.size;
        this.someoneWin = false;
        this.cacheInitialize();
    }
}
