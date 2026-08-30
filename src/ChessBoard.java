import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ChessBoard extends JFrame{

    private JFrame frame;
    private JButton[][] squares = new JButton[8][8];
    private HashMap<String, Image> pieceImage = new HashMap<>();
    private static final int WIDTH = 700;
    private static final int HEIGHT = 800;
    private static final int IMAGE_WIDTH = 80;
    private static final int IMAGE_HIGHT = 90;
    private static final Color LIGHT_WOOD = new Color(240, 217, 181);
    private static final Color DARK_WOOD = new Color(181, 136, 99);

    public ChessBoard(){
        this.frame = new JFrame("Chess Game");
    }

    public void initChessBoard(){
        createBoard();
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        placePieces();
    }

    public void createBoard(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel board = new JPanel(new GridLayout(8, 8));
        frame.add(mainPanel);
        frame.add(board);
        for(int row=0; row < 8; row++){
            for(int col=0; col < 8; col++){
                squares[row][col] = new JButton();
                if ((row + col) % 2 == 0) {
                    squares[row][col].setBackground(DARK_WOOD);
                } else {
                    squares[row][col].setBackground(LIGHT_WOOD);
                }
                squares[row][col].setBorderPainted(false);
                squares[row][col].setOpaque(true);
                squares[row][col].addActionListener(new myActionListener());
                board.add(squares[row][col]);
            }
        }
    }

    public void placePieces(){
        String[] pieces = {"r", "n", "b", "q", "k", "p"};
        String[] colours = {"b", "w"};
        String[] backRow = {"r", "n", "b", "q", "k", "b", "n", "r"};
        for (String colour : colours) {
            for (String piece : pieces) {
                String name = colour + piece;
                pieceImage.put(name, renderImage(name + ".png"));
            }
        }
        for(int col = 0; col < 8; col++){
            setSquare(0, col, pieceImage.get("b" + backRow[col]));
            setSquare(1, col, pieceImage.get("bp"));
            setSquare(6, col, pieceImage.get("wp"));
            setSquare(7, col, pieceImage.get("w" + backRow[col]));
        }
        
    }

    public Image renderImage(String filename){
        try {
            return ImageIO.read(getClass().getResource("resources/images/" + filename));
        } catch (Exception e) {
            System.out.println("Faild to load image: " + filename);
            return null;
        }
    }

    public void setSquare(int row, int col, Image image){
        squares[row][col].setIcon(new ImageIcon(image.getScaledInstance(IMAGE_WIDTH, IMAGE_HIGHT, Image.SCALE_SMOOTH)));
        
    }

    private class myActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("e.getID = " + e.getID());
            System.out.println("e.getActionCommand = " + e.getActionCommand());
            System.out.println("e.getModifiers = " + e.getModifiers());
            System.out.println("e.paramString = " + e.paramString());
            System.out.println("e.getSource = " + e.getSource());
            System.out.println("Button[0][0] = " + squares[0][0]);
        }

    }

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.initChessBoard();
    }
    
}
