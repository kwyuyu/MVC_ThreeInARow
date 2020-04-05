package model;

import model.Utils.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeInARowModel implements AbstractModel {

    private int size;
    private int moveLeft;

    private Map<Player, int[]> rowCache = new HashMap<>();
    private Map<Player, int[]> colCache = new HashMap<>();
    private Map<Player, Integer> diagCache = new HashMap<>();
    private Map<Player, Integer> antiDiagCache = new HashMap<>();

    private boolean someoneWin = false;

    public ThreeInARowModel(int size) {
        this.size = size;
        this.moveLeft = this.size * this.size;

        this.cacheInitialize();

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
    public void takeOneMove() {
        --this.moveLeft;
    }

    @Override
    public int getMoveLeft() {
        return this.moveLeft;
    }

    @Override
    public void update(int row, int col, Player player) {
        // diagonal
        if (row == col) {
            this.diagCache.put(player, this.diagCache.get(player) + 1);
        }

        // anti-diagonal
        if (row + col + 1 == this.size) {
            this.antiDiagCache.put(player, this.antiDiagCache.get(player) + 1);
        }

        // row
        this.rowCache.get(player)[row] += 1;

        // col
        this.colCache.get(player)[col] += 1;

        if (this.diagCache.get(player) == this.size ||
            this.antiDiagCache.get(player) == this.size ||
            this.rowCache.get(player)[row] == this.size ||
            this.colCache.get(player)[col] == this.size) {
            this.someoneWin = true;
        }
    }

    @Override
    public boolean checkIsWin() {
        return this.someoneWin;
    }

    @Override
    public void resetGame() {
        this.moveLeft = this.size * this.size;
        this.someoneWin = false;
        this.cacheInitialize();
    }
}
