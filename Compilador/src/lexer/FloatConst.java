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
public class FloatConst extends Token{
   
    private final float value;

    public FloatConst(float value, String tag) {
        super(tag);
        this.value = value;
    }
    
    public float getValue(){
        return value;
    }
    
    public String getLexeme(){
        return ""+value;
    }
    
}
