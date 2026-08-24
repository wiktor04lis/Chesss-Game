public class Rook extends Piece{

    public Rook(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
        setMovementBehaviour(new RookMovement());
    }
    
}
