public class ChessBoard {
    public static int WHITE = 1;
    public static int BLACK = 0;
    private boolean whitePlaying;
    private boolean isGameEnded;

    private String[] letters = new String[]{"A","B","C","D","E","F","G","H"};
    private int[] num = new int[]{7,6,5,4,3,2,1,0};
    public Piece[][] bo;

    public ChessBoard() {
        this.whitePlaying = true;
        this.isGameEnded = false;
        initialize();
    }

    public void initialize() {
        bo = new Piece[8][8];
        for (int i = 0; i < 8;i++){
            bo[1][i] = new Pawn(0,new Square(i,1));
            bo[6][i] = new Pawn(1,new Square(i,6));
        }
        bo[0][0] = new Rook(0,new Square(0,0));
        bo[0][1] = new Knight(0,new Square(1,0));
        bo[0][2] = new Bishop(0,new Square(2,0));
        bo[0][3] = new Queen(0,new Square(3,0));
        bo[0][4] = new King(0,new Square(4,0));
        bo[0][5] = new Bishop(0,new Square(5,0));
        bo[0][6] = new Knight(0,new Square(6,0));
        bo[0][7] = new Rook(0,new Square(7,0));

        bo[7][0] = new Rook(1,new Square(0,7));
        bo[7][1] = new Knight(1,new Square(1,7));
        bo[7][2] = new Bishop(1,new Square(2,7));
        bo[7][3] = new Queen(1,new Square(3,7));
        bo[7][4] = new King(1,new Square(4,7));
        bo[7][5] = new Bishop(1,new Square(5,7));
        bo[7][6] = new Knight(1,new Square(6,7));
        bo[7][7] = new Rook(1,new Square(7,7));
    }


    public Piece getPieceAt(String from){
        int col = 0;
        String letter = from.substring(0,1).toUpperCase();
        String number = from.substring(1,2);
        int number1 = Integer.parseInt(number);
        for (int i = 0; i < 8;i++) {
            if (letters[i].equals(letter)) {
                col += i;
            }
        }

        return bo[num[number1-1]][col];

    }

    public Square getSquareAt(String to){
        int col = 0;
        String letter = to.substring(0,1).toUpperCase();
        String number = to.substring(1,2);
        int number1 = Integer.parseInt(number);
        for (int i = 0; i < 8;i++) {
            if (letters[i].equals(letter)) {
                col += i;
            }
        }
        int row = num[number1-1];
        return new Square(col,row);

    }

    public Square[] getSquaresBetween(Square s1, Square s2) {
        int count = Math.abs(s1.getRow() - s2.getRow());
        int count2 = Math.abs(s1.getColumn() - s2.getColumn());
        Square[] sqArray;
        if (count != 0) {
            sqArray = new Square[count];
        } else {
            sqArray = new Square[count2];
        }

        if (count != 0 && count2 == 0) {
            int copyRow = s1.getRow();
            int copyColumn = s1.getColumn();
            for (int i = 0; i < count; i++) {
                if (s2.getRowDistance(s1) > 0) {
                    copyRow -= 1;
                    sqArray[i] = new Square(copyColumn, copyRow);
                } else if (s2.getRowDistance(s1) < 0) {
                    copyRow += 1;
                    sqArray[i] = new Square(copyColumn, copyRow);
                }
            }
        } else if (count == 0 && count2 != 0) {
            int copyRow = s1.getRow();
            int copyColumn = s1.getColumn();
            for (int i = 0; i < count2; i++) {
                if (s2.getColumnDistance(s1) > 0) {
                    copyColumn -= 1;
                    sqArray[i] = new Square(copyColumn, copyRow);
                } else if (s2.getColumnDistance(s1) < 0) {
                    copyColumn += 1;
                    sqArray[i] = new Square(copyColumn, copyRow);
                }
            }


        } else if (Math.abs(s1.getRowDistance(s2)) == Math.abs(s1.getColumnDistance(s2))) {
            int copyRow = s1.getRow();
            int copyColumn = s1.getColumn();
            for (int i = 0; i < count; i++) {
                if (s2.getRowDistance(s1) > 0 && s2.getColumnDistance(s1) > 0) {
                    copyRow -= 1;
                    copyColumn -= 1;
                    sqArray[i] = new Square(copyColumn, copyRow);
                } else if (s2.getRowDistance(s1) > 0 && s2.getColumnDistance(s1) < 0) {
                    copyRow -= 1;
                    copyColumn += 1;
                    sqArray[i] = new Square(copyColumn, copyRow);
                } else if (s2.getRowDistance(s1) < 0 && s2.getColumnDistance(s1) < 0) {
                    copyRow += 1;
                    copyColumn += 1;
                    sqArray[i] = new Square(copyColumn, copyRow);
                } else if (s2.getRowDistance(s1) < 0 && s2.getColumnDistance(s1) > 0) {
                    copyRow += 1;
                    copyColumn -= 1;
                    sqArray[i] = new Square(copyColumn, copyRow);
                }
            }
        }

        return sqArray;
    }

    public void nextPlayer() {
        Square.board.setWhitePlaying(!Square.board.whitePlaying);
    }

    public boolean isGameEnded() {
        boolean checkWhite = true;
        boolean checkBlack = true;
        for (int x = 0; x < 8;x++) {
            for (int y = 0; y < 8;y++) {
                if (bo[x][y] != null) {
                    if (bo[x][y].getColor() == 0) {
                        checkBlack = false;
                    } else if (bo[x][y].getColor() == 1) {
                        checkWhite = false;
                    }
                }
            }
        }
        return checkBlack || checkWhite;
    }

    public boolean isWhitePlaying() {
        return whitePlaying;
    }

    public void setWhitePlaying(boolean whitePlaying) {
        this.whitePlaying = whitePlaying;
    }

    @Override
    public String toString() {
        String boardSt = "";
        int number = 8;
         for (int i = 1;i<11;i++) {
             if (i == 1 || i == 10) {
                 for (int x = 0; x < 8; ++x) {
                     if (x == 0) {
                         boardSt += "    "+letters[x];
                     }
                     else if (x == 7) {
                         boardSt += "   "+letters[x]+"    \n";
                     }
                     else {boardSt += "   "+letters[x];}
                 }
             }
             else {
                 for (int x = 0; x < 10;x++) {
                     if ((x == 0) || (x == 9)) {
                         if(x == 0) {
                             boardSt += number+" ";
                         }
                         else {
                             boardSt += "| "+number+"\n";
                         }
                     }
                     else {
                         if (bo[i-2][x-1] == null) {
                             boardSt += "|" + "   ";
                         }
                         else {
                             if (bo[i - 2][x - 1].getColor() == 1) {
                                 String s = bo[i - 2][x - 1].toString();
                                 boardSt += "|" + s.toUpperCase() ;
                             }
                             else {
                                 boardSt += "|" + bo[i - 2][x - 1];
                             }
                         }
                     }
                 }
                 number -= 1;
             }
             if (i != 10) {
                 for (int ln = 0;ln < 35;ln++) {
                     if (ln == 0 || ln == 1) {
                         boardSt += " ";
                     }
                     else {
                         boardSt += "-";
                     }
                 }
                 boardSt += "\n";
             }
         }
         return boardSt;
    }
}