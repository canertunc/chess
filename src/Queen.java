public class Queen extends Piece{

    boolean initialLocation = true;
    public Queen(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return " q ";
    }

    @Override
    public void move(String to) {
        Square targetLocation = Square.board.getSquareAt(to);

        targetLocation.setPiece(this);

        location.clear();
        Square.board.nextPlayer();
    }

    @Override
    public boolean canMove(String to) {

        boolean validMove = false;
        Square targetLocation = Square.board.getSquareAt(to);

        if ((Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] == null)) {
            Square[] between = Square.board.getSquaresBetween(location,
                    targetLocation);
            for (int s = 0; s < between.length;s++) {
                validMove = targetLocation.isEmpty() && between[s].isEmpty();
                if (!validMove) {
                    return validMove;
                }
            }

            return validMove;
        }

        else if ((Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] != null)) {
            if (color == ChessBoard.WHITE) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                        ChessBoard.BLACK;
            } else if (color == ChessBoard.BLACK) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                        ChessBoard.WHITE;
            }
        }
        return validMove;
    }
}
