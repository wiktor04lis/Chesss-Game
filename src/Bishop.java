public class Bishop extends Piece{

    public Bishop(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
        setMovementBehaviour(new BishopMovement());
    }
    
}