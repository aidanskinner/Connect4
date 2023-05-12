
public class Connect4 {
    private Connect4Viewer window;
    public static final String BLANK = " ";
    public static final String RED_MARKER = "R";
    public static final String YELLOW_MARKER = "Y";
    private Square[][] board;

    public Connect4() {
        // Initializes the board
        this.board = new Square[6][7];
        for(int row = 0; row < 6; row++) {
            for(int col = 0; col < 7; col++) {
                this.board[row][col] = new Square(row, col);
                this.board[row][col].setMarker(BLANK);
            }
        }
        // Creates front end
        this.window = new Connect4Viewer(this.board,this);
    }

    public void playGame() {
        window.repaint();
    }

    public boolean isValid(int row, int col) {
        // Checks to see if the row and col of a square is empty
        if(row < 6 && col < 7) {
            return this.board[row][col].getMarker().equals(" ");
        }
        return false;
    }

    public static void main(String[] args) {
        Connect4 game = new Connect4();
        game.playGame();
    }
}
