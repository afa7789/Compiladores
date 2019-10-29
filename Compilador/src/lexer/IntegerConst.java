package lexer;

/**
 *
 * @author Arthur e Jonathan
 */
public class IntegerConst extends Token{
    private final int value;

    public IntegerConst(int value) {
        super(Tag.INTEGER);
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    
    public String getLexeme(){
        return "" + value;
    }
}
