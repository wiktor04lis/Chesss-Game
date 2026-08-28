public class King extends Piece{

    public King(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
        setMovementBehaviour(new KingMovement());
    }
    
}
