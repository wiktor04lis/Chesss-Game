import java.util.ArrayList;

public interface IMovementBehaviour {
    public ArrayList<Move> getLegalMoves(Board board, Piece piece);
}
