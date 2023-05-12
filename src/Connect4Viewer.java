import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Connect4Viewer extends JFrame implements KeyListener{
    private Connect4 backEnd;

    private boolean redWin;
    private boolean yellowWin;

    private int turn;
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 700;
    private Image yellowChip;
    private Image redChip;
    private Image connectLogo;
    private Square[][] board;

    public Connect4Viewer (Square[][] board, Connect4 backEnd) {
        this.board = board;
        this.backEnd = backEnd;
        this.redWin = false;
        this.yellowWin = false;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Connect 4");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        addKeyListener(this);
        this.setVisible(true);
        // Sets images to the file
        yellowChip = new ImageIcon("Resources/yellowChip.jpeg").getImage();
        redChip = new ImageIcon("Resources/redChip.jpeg").getImage();
        connectLogo = new ImageIcon("Resources/Connect4Logo.png").getImage();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int col = 0;
        // Sets the key pressed equal to the col
        if (e.getKeyCode() == KeyEvent.VK_0) {
            col = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_1) {
            col = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_2) {
            col = 2;
        } else if (e.getKeyCode() == KeyEvent.VK_3) {
            col = 3;
        } else if (e.getKeyCode() == KeyEvent.VK_4) {
            col = 4;
        } else if (e.getKeyCode() == KeyEvent.VK_5) {
            col = 5;
        } else if (e.getKeyCode() == KeyEvent.VK_6) {
            col = 5 + 1;
        }
        // If the turn is red, checks to see if the row can be the highest value
        if (this.turn % 2 == 0) {
            if (backEnd.isValid(5, col)) {
                this.board[5][col].setMarker(Connect4.RED_MARKER);
            } else if (backEnd.isValid(4, col)) {
                this.board[4][col].setMarker(Connect4.RED_MARKER);
            } else if (backEnd.isValid(3, col)) {
                this.board[3][col].setMarker(Connect4.RED_MARKER);
            } else if (backEnd.isValid(2, col)) {
                this.board[2][col].setMarker(Connect4.RED_MARKER);
            } else if (backEnd.isValid(1, col)) {
                this.board[1][col].setMarker(Connect4.RED_MARKER);
            } else if (backEnd.isValid(0, col)) {
                this.board[0][col].setMarker(Connect4.RED_MARKER);
            }
        }
        // If the turn is yellow, checks to see if the row can be the highest value
        else if (this.turn % 1 == 0)
            if (backEnd.isValid(5, col)) {
                this.board[5][col].setMarker(Connect4.YELLOW_MARKER);
            } else if (backEnd.isValid(4, col)) {
                this.board[4][col].setMarker(Connect4.YELLOW_MARKER);
            } else if (backEnd.isValid(3, col)) {
                this.board[3][col].setMarker(Connect4.YELLOW_MARKER);
            } else if (backEnd.isValid(2, col)) {
                this.board[2][col].setMarker(Connect4.YELLOW_MARKER);
            } else if (backEnd.isValid(1, col)) {
                this.board[1][col].setMarker(Connect4.YELLOW_MARKER);
            } else if (backEnd.isValid(0, col)) {
                this.board[0][col].setMarker(Connect4.YELLOW_MARKER);
            }
        turn++;
        repaint();
        // If R is pressed, print out Red Wins
        if (e.getKeyCode() == KeyEvent.VK_R) {
            redWin = true;
        }
        // If Y is pressed, print out Yellow Wins
        else if (e.getKeyCode() == KeyEvent.VK_Y) {
            yellowWin = true;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        // Draws the images
        g.drawImage(redChip,0,600,100,100,this);
        g.drawImage(yellowChip,500,600,100,100,this);
        g.drawImage(connectLogo,150,575,300,150,this);
        // Prints the board pieces and board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].draw(g, this);
            }
        }
        // Draws the numbers on top of the cols
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(0), 60,60);
        g.drawString(Integer.toString(1), 135,60);
        g.drawString(Integer.toString(2), 210,60);
        g.drawString(Integer.toString(3), 285,60);
        g.drawString(Integer.toString(4), 360,60);
        g.drawString(Integer.toString(5), 435,60);
        g.drawString(Integer.toString(6), 510,60);

        // Sets the font
        g.setFont(new Font("Seriff", Font.BOLD, 41));
        g.setColor(Color.BLACK);
        // Draws statements for the winning cases
        if (redWin) {
            g.drawString("Red Wins!", 225, 575);
            g.setColor(Color.RED);
            g.setFont(new Font("Seriff", Font.BOLD, 40));
            g.drawString("Red Wins!", 225, 575);
        } else if (yellowWin) {
            g.drawString("Yellow Wins!",225, 575);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Seriff", Font.BOLD, 40));
            g.drawString("Yellow Wins!", 225, 575);
        }

    }
}
