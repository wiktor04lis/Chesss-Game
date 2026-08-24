import java.util.ArrayList;

public interface IMovmentBehaviour {
    public boolean isValidMove(Board board, Piece piece, int toRow, int toCol);
    public ArrayList<Move> getLegalMoves(Board board, Piece piece);
}
