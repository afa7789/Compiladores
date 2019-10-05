package compilador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import lexer.Lexer;
import lexer.LexicalError;
import lexer.Token;

public class Compilador {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // recebe uma lista com comandos em texto. tem 1 arquivo de texto entrado pelo args.
        //1 ª etapa. precisa identificar os tokens, colocar eles em tabelas de simbolos.
        // mostra os tokens 
        String s = args[0];
        System.out.println(s);
        
        Lexer lexy = new Lexer(s);
        Token aux;
        
        try {
            do{
                aux = lexy.scan();
                System.out.println(lexy.getLineCount() +" "+aux.getTag() +" "+ aux.getLexeme());
            }while(!aux.getLexeme().equals("EOF"));
        } catch (LexicalError ex) {
            System.out.println("Lexical Error: " + ex.getMessage());
        }

        System.out.println("\n------------------------\nSymbol Table:\n");
        
        Set<String> keys = lexy.words.keySet();
        for(String key: keys){
            System.out.println("Entry: "+key);
        }
        
        System.out.println("\n------------------------\n");
    }
    
}
