public class Knight extends Piece{

    boolean initialLocation = true;

    public Knight(int color, Square location) {
        super(color, location);
    }

    @Override
    public String toString() {
        return " n ";
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
        if (Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] == null) {
            if ( ((rowDistance == 2 || rowDistance == -2 ) && (columnDistance == -1 ||columnDistance == 1) ) || ((rowDistance == 1 || rowDistance == -1 ) && (columnDistance == -2 || columnDistance == 2)) ) {

                validMove = targetLocation.isEmpty();

                return validMove;
            }
        } else if (Square.board.bo[targetLocation.getRow()][targetLocation.getColumn()] != null) {
            if ( color == ChessBoard.WHITE && ((rowDistance == 2 || rowDistance == -2 ) && (columnDistance == -1 ||columnDistance == 1) ) || ((rowDistance == 1 || rowDistance == -1 ) && (columnDistance == -2 || columnDistance == 2)) ) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                        ChessBoard.BLACK;
            } else if (color == ChessBoard.BLACK && ((rowDistance == 2 || rowDistance == -2 ) && (columnDistance == -1 ||columnDistance == 1) ) || ((rowDistance == 1 || rowDistance == -1 ) && (columnDistance == -2 || columnDistance == 2)) ) {
                validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                        ChessBoard.WHITE;
            }
        }
        return validMove;
    }
}
