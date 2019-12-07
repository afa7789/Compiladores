package compilador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lexer.Lexer;
import lexer.LexicalError;
import lexer.Token;
import syntax.SyntaxAnalyser;

public class Compilador {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String s = args[0];
        System.out.println(s);
        
        Lexer lexy = new Lexer(s);
        Token token;
        List<Token> tokenList;
        List lineData;
        tokenList = new ArrayList();
        lineData = new ArrayList();
        
        try {
            //Lexic
            do{
                token = lexy.scan();
                lineData.add(lexy.line_count);
                tokenList.add(token);
            }while(!token.getLexeme().equals("EOF"));
            
            //Syntax
            SyntaxAnalyser syntax = new SyntaxAnalyser(tokenList, lineData, lexy.words);
            syntax.scan();
            
            syntax.errorList.forEach((message) -> {
                System.out.println(message);
            });
            
        } catch (LexicalError ex) {
            System.out.println("Lexical Error: " + ex.getMessage());
        }
    }
    
}
