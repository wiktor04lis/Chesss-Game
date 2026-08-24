public class RookMovement extends DirectionalMovement{

    /*
    {0, 1} Horizontal right 
    {0, -1} Horizontal left
    {-1, 0} Vertical Up
    {1, 0} Vertical Down
    */

    @Override
    public int[][] getDirection() {
        return new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    }
    
}
