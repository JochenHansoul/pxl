package Opgave2;

public class ChessPiece implements Movable<ChessBoardLocation>{
    ChessBoardLocation location;

    @Override
    public void move(ChessBoardLocation location) {
        this.location = location;
    }

    @Override
    public ChessBoardLocation getLocation() {
        return location;
    }
}
