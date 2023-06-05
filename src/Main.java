import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        ChessBoard board = new ChessBoard();
        System.out.println(board);

        while (!Square.board.isGameEnded()){
            System.out.println("It is " + (Square.board.isWhitePlaying() ? "White" : "Black") + "'s turn");
            Piece piece = null;
            do {
                System.out.print("Enter the location of the piece:");
                String from = reader.next();
                piece = Square.board.getPieceAt(from);
            }while(piece == null || piece.getColor()!=(Square.board.isWhitePlaying() ? ChessBoard.WHITE :
                    ChessBoard.BLACK));
            String to = null;
            do {
                System.out.print("Enter the new location of the piece:");
                to = reader.next();
            }while(!piece.canMove(to));
            piece.move(to);
            System.out.println(Square.board);
        }
        reader.close();
    }
}
