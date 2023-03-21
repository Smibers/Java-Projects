package FunkyGame;

public class RandomToken extends FunkyToken{
    
    public RandomToken(char token) {
        super(token);
    }
    
    public void move(FunkyBoard board) {

        rowPos = (int)(Math.random() * board.size);
        columnPos = (int)(Math.random() * board.size);
        
        board.placeToken(this, rowPos, columnPos);

    }
    
    
}
