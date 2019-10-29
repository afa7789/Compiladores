package compilador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lexer.Lexer;
import lexer.LexicalError;
import lexer.Tag;
import lexer.Token;
import syntax.SyntaxAnalyser;
import syntax.SyntaxError;

public class Compilador {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String s = args[0];
        System.out.println(s);
        
        Lexer lexy = new Lexer(s);
        Token token;
        List<Token> tokenList;
        tokenList = new ArrayList();
        
        try {
            //Lexic
            do{
                token = lexy.scan();
                tokenList.add(token);
            }while(!token.getLexeme().equals("EOF"));
            
            //Syntax
            SyntaxAnalyser syntax = new SyntaxAnalyser(tokenList);
            
            syntax.scan();
            
        } catch (LexicalError ex) {
            System.out.println("Lexical Error: " + ex.getMessage());
        } catch (SyntaxError ex) {
            System.out.println("Syntax Error: " + ex.getMessage());
        }
    }
    
}
