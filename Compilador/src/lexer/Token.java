package lexer;

/**
 *
 * @author Arthur e Jonathan
 */
public class Token {
    private final String tag;
    private final String lexeme;

    public Token(String tag){
        this.tag = tag;
        this.lexeme = "";
    }
    
    public Token(String tag,String value){
        this.tag = tag;
        this.lexeme = value;
    }
    
    public String getTag(){
        return this.tag;
    }
    
    public String getLexeme(){
        return this.lexeme;
    }
    
    
}
