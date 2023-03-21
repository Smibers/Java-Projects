package FunkyGame;

public class MoveOneToken extends FunkyToken {

	public MoveOneToken(char token) {
		super(token);
	}
	
	public void move(FunkyBoard board) {
        int originalRowPosition = 0;
        int originalColumnPosition = 0;
        int newRowPos = initialRowPos;
        int newColumnPos = initialColumnPos;
        
        
        int chanceRow = ((int)(Math.random() * 3) + 1);
        if (chanceRow == 1) {
            newRowPos -= 1;
        }
        if (chanceRow == 2) {
            newRowPos += 1;
        }
//        if (chanceRow == 3) {
//            //setRowPos(rowPos);
//            newRowPos = newRowPos;
//        }
        
        int chanceColumn = ((int)(Math.random() * 3) + 1);
        if (chanceColumn == 1) {
            newColumnPos -= 1;
        }
        if (chanceColumn == 2) {
            newColumnPos += 1;
        }
//        if (chanceColumn == 3) {
//            newColumnPos = newColumnPos;
//        }
        
        while(newRowPos > board.size - 1 || newRowPos < 0) {
            chanceRow = ((int)(Math.random() * 3) + 1);
            if (chanceRow == 1) {
                originalRowPosition = newRowPos;
                newRowPos -= 1;
            }
            if (chanceRow == 2) {
                originalRowPosition = newRowPos;
                newRowPos += 1;
            }
            if (chanceRow == 3) {
                originalRowPosition = newRowPos;
            }
        }
        
        while(newColumnPos > board.size -1 || newColumnPos < 0) {
            chanceColumn = ((int)(Math.random() * 3) + 1);
            if (chanceColumn == 1) {
                originalColumnPosition = newColumnPos;
                newColumnPos -= 1;
            }
            if (chanceColumn == 2) {
                originalColumnPosition = newColumnPos;
                newColumnPos += 1;
            }
            if (chanceColumn == 3) {
                originalColumnPosition = newColumnPos;
            }
        }
        
        board.placeToken(this, newRowPos, newColumnPos);

    }
	
	
	
	
	
}
