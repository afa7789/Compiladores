/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

/**
 *
 * @author aluno-ccc
 */
public class Tag {
    
    public final static String 
            // palavras reservadas
            EXIT            = "EXIT",
            START           = "START" ,
            // tipos
            INT             = "INT",
            FLOAT           = "FLOAT",
            STRING          = "STRING",
            // controle de fluxo
            IF              = "IF",
            THEN            = "THEN",
            ELSE            = "ELSE",
            END             = "END",
            // repeticao
            DO              = "DO",
            WHILE           = "WHILE",
            // IO
            SCAN            = "SCAN",
            PRINT           = "PRINT",
            // booleanos
            NOT             = "NOT",
            OR              = "OR",
            AND             = "AND",
            
            // aspas
            // “
            QUOTE_RIGHT     = "“",
            
            // ”
            QUOTE_LEFT      = "”",
            
            //operadores
            // +
            SUM             = "SUM",
            
            // -
            MINUS           = "MINUS",
            // * 
            MULT            = "MULT",
            
            // /
            DIV             = "DIV",
            
            // ==
            COMPARATION     = "COMPARATION",
            
            // =
            EQUAL           = "EQUAL",
            
            // >
            GREATHER_THAN   = "GREATHER_THAN",
            
            // <
            LESS_THAN       = "LESS_THAN",
            
            // >=
            GREATHER_EQUAL  = "GREATHER_EQUAL",
            
            // <=
            LESS_EQUAL      = "LESS_EQUAL",
            
            // <>
            DIFF            = "DIFF",
            
            // ;
            SEMICOLON       = "SEMICOLON",
            
            // ,
            COMMA           = "COMMA",
            
            // (  )
            OPEN_PAR        = "OPEN_PAR",
            
            CLOSE_PAR       = "CLOSE_PAR",
            
            // {  }
            OPEN_C          = "OPEN_C",
            CLOSE_C         = "CLOSE_C",
            
            // '.'
            DOT             = "DOT",
            
            // contante literal            
            LITERAL         = "LITERAL",
            
            // contantes numericas
            INTEGER         = "INTEGER",
            FLOATING        = "FLOATING",
            
            // identificadores
            ID              = "ID",
            
            // token desconhecido
            UNKNOWN         = "UNKNOWN",
            COMMENT         = "COMMENT";

}
