/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

/**
 *
 * @author Jonathan
 */
public class LexicalError extends Exception{

    public LexicalError(String ch, int line) {
        super("Unexpected character \"" + ch + "\" at line " + line);
    }
    
}
