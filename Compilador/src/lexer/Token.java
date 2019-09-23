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
