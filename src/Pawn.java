public class Pawn extends Piece{
    private final Move startingSquare;
    private final int promoteRow;

    public Pawn(int row, int col, boolean isWhite) {
        super(row, col, isWhite);
        this.startingSquare = new Move(row, col);
        this.promoteRow = isWhite ? 0 : 7;
        setMovementBehaviour(new PawnMovement());
    }
    
    public Move getStartingSquare() {
        return startingSquare;
    }

    public int getPromoteRow() {
        return promoteRow;
    }
}
