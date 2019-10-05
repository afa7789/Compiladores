package lexer;

/**
 *
 * @author Arthur e Jonathan
 */
public class IntegerConst extends Token{
    private final int value;

    public IntegerConst(String tag, int value) {
        super(tag);
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    
    public String getLexeme(){
        return "" + value;
    }
}
