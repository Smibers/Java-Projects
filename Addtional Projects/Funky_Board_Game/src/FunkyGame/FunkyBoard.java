package FunkyGame;

public class FunkyBoard {
    public FunkyToken[][] board;
    public int size;
    public char emptySpace = '-';
    
    public FunkyBoard(int size) {
        this.size = size;
        board = new FunkyToken [size][size];
    }
    
    public void displayBoard() {
        for(int i = 0; i < size; i++) {
            System.out.print("|");
            for(int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print((board[i][j] + "|"));
                } else {
                    System.out.print(emptySpace + "|");
                }
            }
            System.out.println();
        }
    }
    
    public void placeToken(FunkyToken token, int row, int column) {
        this.board[token.initialRowPos][token.initialColumnPos] = null;
    
        if (board[row][column] != null) {
            board[row][column].active = false;
        }
        
        this.board[row][column] = token;
        
        token.initialRowPos = row;
        token.initialColumnPos = column;
            
    }
    
    public FunkyToken[][] getBoard() {
        return board;
    }
    
    public FunkyToken getWinner() {    
        int tokenCounter = 0;
        int rowPos = 0;
        int columnPos = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    tokenCounter +=1;
                    rowPos = i;
                    columnPos = j;
                    if (tokenCounter > 1) {
                        return null;
                    }
                }
            }
        }
            return board[rowPos][columnPos];
    }
    
    
}
