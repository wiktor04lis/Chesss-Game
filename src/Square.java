public class Square {
    private final int row;
    private final int col;
    private Piece piece;

    public Square(int row, int col, Piece piece){
        this.row=row;
        this.col=col;
        this.piece=piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean hasPiece(){
        return piece != null;
    }
    
}
