import java.util.ArrayList;

public abstract class DirectionalMovement implements IMovementBehaviour{
    public abstract int[][] getDirection();

    @Override
    public ArrayList<Move> getLegalMoves(Board board, Piece piece){
        ArrayList<Move> moves = piece.getLegalMoves();
        for(int[] direction : getDirection()){
            addMoves(board, moves, piece, direction[0], direction[1]);
        }
        return moves;
    }

    private void addMoves(Board board, ArrayList<Move> moves, Piece piece ,int rowDirection, int colDirection){
        Square[][] square = board.getBoard();
        int currRow = piece.getRow();
        int currCol = piece.getCol();
        int row = currRow + rowDirection;
        int col = currCol + colDirection;
        while (row >= 0 && row < 8 && col >= 0 && col < 8) {
            if (square[row][col].hasPiece()) {
                Piece foundPiece = square[row][col].getPiece();
                if (piece.isWhite() != foundPiece.isWhite()) {
                    moves.add(new Move(row, col));
                }
                break;
            }
            Move addMove = new Move(row, col);
            moves.add(addMove);
            row+=rowDirection;
            col+=colDirection;
        }
    }
}
