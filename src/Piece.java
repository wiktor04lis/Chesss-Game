import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private int row;
    private int col;
    private boolean isWhite;
    private ArrayList<Move> legalMoves;
    private IMovmentBehaviour movmentBehaviour;

    public Piece(int row, int col, boolean isWhite) {
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
    }

    public List<Move> findLegalMoves(Board board) {
        legalMoves = movmentBehaviour.getLegalMoves(board, this);
        return legalMoves;
    }

    public boolean isValidMove(Board board, int toRow, int toCol){
        return movmentBehaviour.isValidMove(board, this, toRow, toCol);
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

    public IMovmentBehaviour getMovmentBehaviour() {
        return movmentBehaviour;
    }

    public void setMovmentBehaviour(IMovmentBehaviour movmentBehaviour) {
        this.movmentBehaviour = movmentBehaviour;
    }
    
}
