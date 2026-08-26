public class QueenMovement extends DirectionalMovement{

    /* 
    Directions are a combination of Bishop and Rook.
    */

    @Override
    public int[][] getDirection() {
        return new int[][] {{-1, 1}, {-1,-1}, {1,1}, {1,-1}, {1,0}, {-1,0}, {0,1}, {0,-1}};
    }
    
}
