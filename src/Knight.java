public class Knight extends Piece{

    public Knight(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
        setMovementBehaviour(new KnightMovement());
    }
    
}
