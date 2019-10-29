/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntax;

/**
 *
 * @author Jonathan
 */
public class SyntaxError extends Exception{

    public SyntaxError(String token, int line) {
        super("Unexpected token \"" + token + "\" at line " + line);
    }
    
}
