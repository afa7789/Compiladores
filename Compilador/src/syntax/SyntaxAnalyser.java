/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntax;

import java.util.ArrayList;
import java.util.List;
import lexer.Tag;
import lexer.Token;

/**
 *
 * @author Jonathan e Arthur
 */
public class SyntaxAnalyser {
    
    public Token token;
    private int index;
    private List<Token> tokenList;
    private List<Integer> lineData;
    public List<String> errorList;
    private int line_count;
    
    public SyntaxAnalyser(List<Token> list, List<Integer> lines){
        index = 0;
        tokenList = list;
        lineData = lines;
        errorList = new ArrayList();
        token = getToken(); //lê primeiro token
        line_count = 0;
    }
    
    private Token getToken(){
        index ++;
        line_count = lineData.get(index-1);
        return tokenList.get(index-1);
    }
    
    void advance() {
        token = getToken(); //lê próximo token
    }
    
    void eat(String tag){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        if (token.getTag().equals(Tag.EOF)) return;
        if (token.getTag().equals(tag)) advance();
        else {error();}
    }
    
    void error(){
        String message = "Unexpected token \"" + token.getLexeme() + "\" at line " + line_count;
        errorList.add(message);
    }
    
    public void scan(){
        P_START(); eat(Tag.EOF);
    }
    
    void P_START(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        eat(Tag.START); PROGRAM();
    }
    
    void PROGRAM(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch (token.getTag()){
            case Tag.INT:
            case Tag.FLOAT:
            case Tag.STRING:
                DECL_LIST();
                STMT_LIST();
                eat(Tag.EXIT);
                break;
                
            case Tag.ID:
            case Tag.IF:
            case Tag.SCAN:
            case Tag.DO:
            case Tag.PRINT:
                STMT_LIST();
                eat(Tag.EXIT);
                break;

            default: error();
        }
    }
    
    void DECL_LIST(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        DECL();
        DECL_REC();
    }
    
    void DECL_REC(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.INT:
            case Tag.FLOAT:
            case Tag.STRING:
                DECL();
                DECL_REC();
                break;
            default: break;
        }
    }
    
    void DECL(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.INT:
            case Tag.FLOAT:
            case Tag.STRING:
                TYPE(); IDENT_LIST(); eat(Tag.SEMICOLON);
                break;
            default: error();
        }
    }
    
    void IDENT_LIST(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        eat(Tag.ID); IDENT_REC();
    }
    
    void IDENT_REC(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.COMMA:
                eat(Tag.COMMA); eat(Tag.ID); IDENT_REC(); break;
            default: break;
        }
    }
    
    void TYPE(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.INT:
                eat(Tag.INT);break;
            case Tag.FLOAT:
                eat(Tag.FLOAT); break;
            case Tag.STRING:
                eat(Tag.STRING); break;
            default: error();
        }
    }
    
    void STMT_LIST(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        STMT(); STMT_REC();
    }
    
    void STMT_REC(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.ID:
            case Tag.IF:
            case Tag.DO:
            case Tag.SCAN:
            case Tag.PRINT:
                STMT(); STMT_REC(); break;
            default: break;
        }
    }
    
    void STMT(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.ID:
                ASSIGN_STMT(); eat(Tag.SEMICOLON); break;
            case Tag.IF:
                IF_STMT(); break;
            case Tag.DO:
                WHILE_STMT(); break;
            case Tag.SCAN:
                READ_STMT(); eat(Tag.SEMICOLON); break;
            case Tag.PRINT:
                WRITE_STMT(); eat(Tag.SEMICOLON); break;
            default: error();
        }
    }
    
    void ASSIGN_STMT(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        eat(Tag.ID); eat(Tag.EQUAL); SIMPLE_EXP(); 
    } 
    
    void IF_STMT(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        eat(Tag.IF); CONDITION(); eat(Tag.THEN); STMT_LIST(); IF_END();
    } 
    
    void IF_END(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.END:
                eat(Tag.END); break;
            case Tag.ELSE:
                eat(Tag.ELSE); STMT_LIST(); eat(Tag.END); break;
            default: error();
        }
    }
    
    void CONDITION(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        EXPRESSION();
    }
    
    void WHILE_STMT(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        eat(Tag.DO); STMT_LIST(); STMT_SUFIX();
    } 
    
    void STMT_SUFIX(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        eat(Tag.WHILE); CONDITION(); eat(Tag.END);
    } 
    
    void READ_STMT(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        eat(Tag.SCAN); eat(Tag.OPEN_PAR); eat(Tag.ID); eat(Tag.CLOSE_PAR);
    } 
    
    void WRITE_STMT(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        eat(Tag.PRINT); eat(Tag.OPEN_PAR); WRITABLE(); eat(Tag.CLOSE_PAR);
    } 
    
    void WRITABLE(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        SIMPLE_EXP();
    }
    
    void EXPRESSION(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        SIMPLE_EXP(); EXP_END();
    }
    
    void EXP_END(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.COMPARATION:
            case Tag.GREATHER_EQUAL:
            case Tag.GREATHER_THAN:
            case Tag.LESS_EQUAL:
            case Tag.LESS_THAN:
            case Tag.DIFF:
                REL_OP(); SIMPLE_EXP(); break;
            default: break;
        }
    }
    
    void SIMPLE_EXP(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        TERM(); SIMPLE_END();
    }
    
    void SIMPLE_END(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.MINUS:
            case Tag.OR:
            case Tag.PLUS:
                ADD_OP(); TERM(); SIMPLE_END(); break;
            default: break;
        }
    }
    
    void TERM(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        FACTOR_A(); TERM_END();
    }
    
    void TERM_END(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.MULT:
            case Tag.DIV:
            case Tag.AND:
                MUL_OP(); FACTOR_A(); TERM_END(); break;
            default: break;
        }
    }
    
    void FACTOR_A(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.MINUS:
                eat(Tag.MINUS); FACTOR(); break;
            case Tag.NOT:
                eat(Tag.NOT); FACTOR(); break;
            case Tag.OPEN_PAR: 
            case Tag.ID: 
            case Tag.INTEGER: 
            case Tag.FLOATING:
            case Tag.LITERAL:
                FACTOR(); break;
            
            default: error(); break;
        }
    }
    
    void FACTOR(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.ID:
                eat(Tag.ID); break;
            case Tag.OPEN_PAR:
                eat(Tag.OPEN_PAR); EXPRESSION(); eat(Tag.CLOSE_PAR); break;
            case Tag.INTEGER: 
            case Tag.FLOATING:
            case Tag.LITERAL:
                CONSTANT(); break;
            
            default: error(); break;
        }
    }
    
    void REL_OP(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.COMPARATION:
                eat(Tag.COMPARATION);break;
            case Tag.LESS_EQUAL:
                eat(Tag.LESS_EQUAL);break;
            case Tag.GREATHER_EQUAL:
                eat(Tag.GREATHER_EQUAL); break;
            case Tag.GREATHER_THAN:
                eat(Tag.GREATHER_THAN);break;
            case Tag.LESS_THAN:
                eat(Tag.LESS_THAN);break;
            case Tag.DIFF:
                eat(Tag.DIFF);break;
            default: error();
        }
    }
    
    void ADD_OP(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.PLUS:
                eat(Tag.PLUS);break;
            case Tag.MINUS:
                eat(Tag.MINUS);break;
            case Tag.OR:
                eat(Tag.OR); break;
            default: error();
        }
    }
    
    void MUL_OP(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.MULT:
                eat(Tag.MULT);break;
            case Tag.DIV:
                eat(Tag.DIV);break;
            case Tag.AND:
                eat(Tag.AND); break;
            default: error();
        }
    }
    
    void CONSTANT(){
        while(token.getTag().equals(Tag.COMMENT)) advance();
        switch(token.getTag()){
            case Tag.INTEGER:
                eat(Tag.INTEGER);break;
            case Tag.FLOATING:
                eat(Tag.FLOATING);break;
            case Tag.LITERAL:
                eat(Tag.LITERAL); break;
            default: error();
        }
    }
}
