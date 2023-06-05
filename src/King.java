public class King extends Piece{

    public King(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return " k ";
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
        int rowDistance = targetLocation.getRowDistance(location);
        int columnDistance = targetLocation.getColumnDistance(location);

        if ((Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] == null)) {

            if (Math.abs(rowDistance) <= 1 && Math.abs(columnDistance) <= 1) {
                validMove = true;
                return validMove;
            }
            else {
                return validMove;
            }
        }

        else if ((Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] != null) && (Math.abs(rowDistance) <= 1 && Math.abs(columnDistance) <= 1)) {
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
