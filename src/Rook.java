public class Rook extends Piece{

    boolean initialLocation = true;
    public Rook(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return " r ";
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
        if ((Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] == null) && ( (Math.abs(rowDistance) == 0 && Math.abs(columnDistance) > 0) || (Math.abs(rowDistance) > 0 && Math.abs(columnDistance) == 0)) ) {

            if (initialLocation) {

                Square[] between = Square.board.getSquaresBetween(location,
                        targetLocation);
                for (int s = 0; s < between.length;s++) {
                    validMove = targetLocation.isEmpty() && between[s].isEmpty();
                    if (!validMove) {
                        return validMove;
                    }
                }
            }
            return validMove;
        }

        else if ((Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] != null) && ( (Math.abs(rowDistance) == 0 && Math.abs(columnDistance) > 0) || (Math.abs(rowDistance) > 0 && Math.abs(columnDistance) == 0)) ) {
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
