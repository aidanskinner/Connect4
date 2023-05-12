import java.awt.*;

public class Square {
    private String marker;
    private int row;
    private int col;

    private final static int SQUARE_WIDTH = 75;

    private final static int SQUARE_HEIGHT = 75;

    private final static int STARTING_X = 25;
    private final static int STARTING_Y = 75;

    public Square (int row, int col) {
        // Initializes the square's row and col
        this.row = row;
        this.col = col;
        // Sets the square's marker as blank
        this.marker = " ";
    }

    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g, Connect4Viewer v){
        // Starting x and y values for the squares
        int my_x = STARTING_X + SQUARE_WIDTH * col;
        int my_y = STARTING_Y + SQUARE_WIDTH * row;
        // Draws the board
        g.setColor(Color.black);
        g.drawRect(my_x,my_y, SQUARE_WIDTH, SQUARE_HEIGHT);
        // If statements for the board pieces, if the marker is R then draw red circle,
        // and if the marker is Y then draw yellow circle
        if (this.getMarker().equals("R")) {
            g.setColor(Color.RED);
            g.drawOval(my_x + 15,my_y + 15,50,50);
            g.fillOval(my_x + 15,my_y + 15,50,50);
        }
        if (this.getMarker().equals("Y"))
        {
            g.setColor(Color.YELLOW);
            g.drawOval(my_x + 15,my_y + 15,50,50);
            g.fillOval(my_x + 15,my_y + 15,50,50);
        }
    }
}
