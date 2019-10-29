package lexer;

/**
 *
 * @author Arthur e Jonathan
 */
public class FloatConst extends Token{
   
    private final float value;

    public FloatConst(float value) {
        super(Tag.FLOATING);
        this.value = value;
    }
    
    public float getValue(){
        return value;
    }
    
    public String getLexeme(){
        return ""+value;
    }
    
}
