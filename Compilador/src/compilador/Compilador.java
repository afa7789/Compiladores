package compilador;

import java.io.FileNotFoundException;
import java.io.IOException;
import lexer.Lexer;
import lexer.Token;

public class Compilador {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // recebe uma lista com comandos em texto. tem 1 arquivo de texto entrado pelo args.
        //1 ª etapa. precisa identificar os tokens, colocar eles em tabelas de simbolos.
        // mostra os tokens 
        String s = args[0];
        System.out.println(s);
        
        Lexer lexy = new Lexer(s);
        Token aux ;
        do{
            aux = lexy.scan();
            System.out.println(lexy.getLineCount() +" "+aux.getTag() +" "+ aux.getLexeme());
        }while(!aux.getLexeme().equals("EOF"));
    }
    
}
