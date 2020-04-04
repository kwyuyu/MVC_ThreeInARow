package model.Utils;

public enum Player {
    P1("O", 1), P2("X", 2);

    private final String marker;
    private final int id;

    Player(String marker, int id) {
        this.marker = marker;
        this.id = id;
    }

    public String getMarker() {
        return this.marker;
    }

    public int getId() {
        return this.id;
    }
}
