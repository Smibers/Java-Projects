package FunkyGame;

public abstract class FunkyToken {
    public char token;
    public int rowPos;
    public int columnPos;
    public boolean active = true;
    
    public int initialRowPos;
    public int initialColumnPos;
    
    public abstract void move(FunkyBoard board);
    
    public FunkyToken(char token) {
        this.token = token;
        
    }
    
    public String toString() {
        return "" + token;
    }
}
