public class Bishop extends Piece {

    boolean initialLocation = true;
    public Bishop(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return " b ";
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
        if (Math.abs(rowDistance) == Math.abs(columnDistance) && Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] == null) {
            if (Math.abs(rowDistance) > 0 ) {
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
            }
            return validMove;
        }

        else if (Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] != null && Math.abs(rowDistance) == Math.abs(columnDistance)) {
            if (color == ChessBoard.WHITE && Math.abs(rowDistance) > 0) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                        ChessBoard.BLACK;
            } else if (color == ChessBoard.BLACK && Math.abs(rowDistance) > 0) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                        ChessBoard.WHITE;
            }
        }
        return validMove;
    }
}