
public class Square {
    private int column;
    private int row;

    public static ChessBoard board = new ChessBoard();
    private String[] letters = new String[]{"A","B","C","D","E","F","G","H"};


    public Square(int column, int row) {
        this.column = column;
        this.row = row;

    }

    public boolean isAtLastRow(int color){

        if (color == 0) {
            if (getRow() == 7) {
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if (getRow() == 0) {
                return true;
            }
            else {
                return false;
            }

        }
    }

    public void putNewQueen(int color) {
        getBoard().bo[getRow()][getColumn()] = new Queen(color,new Square(getColumn(),getRow()));
    }

    public void setPiece(Piece piece) {

        if (piece.toString().toLowerCase() == " p "){
            board.bo[getRow()][getColumn()] = new Pawn(piece.getColor(), new Square(getColumn(), getRow()));
        }
        else if (piece.toString().toLowerCase() == " n ") {
            board.bo[getRow()][getColumn()] = new Knight(piece.getColor(), new Square(getColumn(), getRow()));

        }
        else if (piece.toString().toLowerCase() == " b ") {
            board.bo[getRow()][getColumn()] = new Bishop(piece.getColor(), new Square(getColumn(), getRow()));

        }
        else if (piece.toString().toLowerCase() == " r ") {
            board.bo[getRow()][getColumn()] = new Rook(piece.getColor(), new Square(getColumn(), getRow()));

        }
        else if (piece.toString().toLowerCase() == " q ") {
            board.bo[getRow()][getColumn()] = new Queen(piece.getColor(), new Square(getColumn(), getRow()));

        }
        else if (piece.toString().toLowerCase() == " k ") {
            board.bo[getRow()][getColumn()] = new King(piece.getColor(), new Square(getColumn(), getRow()));

        }

    }

    public void clear() {
        getBoard().bo[getRow()][getColumn()] = null;

    }


    public boolean isEmpty() {

        if (Square.board.bo[getRow()][getColumn()] == null) {
            return true;
        }
        else {
            return false;
        }

    }
    public boolean isAtSameColumn(Square s) {

        if (s.getColumn() == getColumn()) {
            return true;
        }
        else {
            return false;
        }

    }

    public int getRowDistance(Square location) {
        return location.getRow() - getRow();
    }
    public int getColumnDistance(Square location) {
        return location.getColumn() - getColumn();
    }

    public boolean isNeighborColumn(Square s) {

        if (getColumn() - s.getColumn() == 1 || getColumn() - s.getColumn() == -1) {
            return true;
        }
        else {
            return false;
        }
    }

    public Piece getPiece() {
        return board.bo[getRow()][getColumn()];
    }


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public  ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        Square.board = board;
    }
}
