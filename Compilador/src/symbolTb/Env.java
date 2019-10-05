/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbolTb;
import lexer.*;
import java.util.*;

/**
 *
 * @author Arthur e Jonathan
 */
public class Env {
    public Hashtable table;
    protected Env prev;

    public Env(Env n){
        table = new Hashtable();
        prev = n;
    }
    
    public void put(Token w, Id i){
        table.put(w,i);
    }
    
    public Id get(Token w){
        for (Env e = this; e!=null; e = e.prev){
            Id found = (Id) e.table.get(w);
            if (found != null)
                return found;
        }
        return null;
    }

    public void show(){
        Set<Word> keys = table.keySet();
        for(Word key: keys){
            System.out.println("Entry: "+key.getLexeme());
        }
    }
}

