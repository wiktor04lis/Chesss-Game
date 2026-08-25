public class BishopMovement extends DirectionalMovement{

    /*
    {-1, 1} Diagonal Right Up
    {-1, -1} Diagonal Left Up
    {1, 1} Diagonal Right Down
    {1, -1} Diagonal Left Down
    */

    @Override
    public int[][] getDirection() {
        return new int[][] {{-1, 1}, {-1,-1}, {1,1}, {1,-1}};
    }
    
}
