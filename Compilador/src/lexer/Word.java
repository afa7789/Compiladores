package lexer;

/**
 *
 * @author Arthur e Jonathan
 */
public class Word extends Token {
    
    private String lexeme = "";
    public String type = null;
    
    public Word(String tag) {
        super(tag);
    }
    
    public Word(String tag , String lexeme){
        super(tag);
        this.lexeme = lexeme;
    }
    
    public String getLexeme(){
        return this.lexeme;
    }
     
}
