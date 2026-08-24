import java.util.ArrayList;

public abstract class Piece {
    private int row;
    private int col;
    private boolean isWhite;
    private ArrayList<Move> legalMoves = new ArrayList<>();
    private IMovementBehaviour movementBehaviour;

    public Piece(int row, int col, boolean isWhite) {
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
    }

    public ArrayList<Move> findLegalMoves(Board board) {
        legalMoves = movementBehaviour.getLegalMoves(board, this);
        return legalMoves;
    }

    public boolean isValidMove(Board board, int toRow, int toCol){
        return movementBehaviour.isValidMove(board, this, toRow, toCol);
    }

    public ArrayList<Move> getLegalMoves() {
        return legalMoves;
    }

    public Move getPosition(){
        return new Move(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public IMovementBehaviour getMovementBehaviour() {
        return movementBehaviour;
    }

    public void setMovementBehaviour(IMovementBehaviour movementBehaviour) {
        this.movementBehaviour = movementBehaviour;
    }
    
}
