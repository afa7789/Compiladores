/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

/**
 *
 * @author arthur
 */
public class Word extends Token {
    
    private String lexeme = "";
    
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
