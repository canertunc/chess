
public class Piece {
    protected int color;
    protected Square location;

    public Piece(int color,Square location) {
        this.color = color;
        this.location = location;
    }

    public  void move(String to) {};

    public boolean canMove(String destination){return true;};

    public int getColor() {
        return color;
    }

}
