import java.util.ArrayList;

public class KnightMovement implements IMovementBehaviour{

    /*
    {-2, 1} Up Right 
    {-1, 2} Right Up
    {1, 2} Right Down
    {2, 1} Down Right
    {2, -1} Down Left
    {1, -2} Left Down
    {-1, -2} Left Up
    {-2, -1} Up Left
    */

    private int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    @Override
    public ArrayList<Move> getLegalMoves(Board board, Piece piece) {
        ArrayList<Move> moves = piece.getLegalMoves();
        Square[][] square = board.getBoard();
        int currRow = piece.getRow();
        int currCol = piece.getCol();
        for (int[] direction : directions) {
            int row = currRow + direction[0];
            int col = currCol + direction[1];
            if (row >= 0 && row < 8 && col >= 0 && col < 8) {
                if (!square[row][col].hasPiece()) {
                    moves.add(new Move(row, col));
                } else {
                    Piece foundPiece = square[row][col].getPiece();
                    if (foundPiece.isWhite() != piece.isWhite()) {
                        moves.add(new Move(row, col));
                    }
                }
            }
        }
        return moves;
    }
    
}
