import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessBoard extends JFrame{

    private JFrame frame;
    private JButton[][] squares = new JButton[8][8];
    private static final int WIDTH = 700;
    private static final int HEIGHT = 800;
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

    private class myActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getID());
        }

    }

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.initChessBoard();
    }
    
}
