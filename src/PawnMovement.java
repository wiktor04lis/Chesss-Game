import java.util.ArrayList;

public class PawnMovement implements IMovementBehaviour{

    @Override
    public ArrayList<Move> getLegalMoves(Board board, Piece piece) {
        ArrayList<Move> moves = piece.getLegalMoves();
        Square[][] square = board.getBoard();
        Pawn pawn = (Pawn) piece;
        int direction = pawn.getStartingSquare().getRow() == 6 ? -1 : 1;
        int row = pawn.getRow();
        int col = pawn.getCol();

        // Starting Square
        if (pawn.getPosition().equals(pawn.getStartingSquare())) {
            if (!square[row + direction][col].hasPiece()) {
                moves.add(new Move(row + direction, col));
                if (!square[row + direction * 2][col].hasPiece()) {
                    moves.add(new Move(row + direction * 2, col));
                }
            }
        } // Advancement 
        else if (!square[row + direction][col].hasPiece()) {
            moves.add(new Move(row + direction, col));
        }

        // Capture 
        int captureRow = row + direction;
        int[] cols = {col - 1, col + 1};
        if (captureRow >= 0 && captureRow < 8) {
            for (int c : cols) {
                if (c >= 0 && c < 8) {
                    if (square[captureRow][c].hasPiece()) {
                        Piece foundPiece = square[captureRow][c].getPiece();
                        if (foundPiece.isWhite() != pawn.isWhite()) {
                            moves.add(new Move(captureRow, c));
                        }
                    }
                }
            }
        }

        return moves;
    }
    
}
