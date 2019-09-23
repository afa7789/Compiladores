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
public class IntegerConst extends Token{
    private final int value;

    public IntegerConst(int value, String tag) {
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
