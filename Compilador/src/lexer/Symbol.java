package lexer;

/**
 *
 * @author Arthur e Jonathan
 */
public class Symbol extends Token {
    
    private String lexeme = "";
    
    public static final Symbol comparation     = new Symbol(Tag.COMPARATION   ,"==");
    public static final Symbol greather_than   = new Symbol(Tag.GREATHER_THAN , ">");
    public static final Symbol greather_equal  = new Symbol(Tag.GREATHER_EQUAL,">=");
    public static final Symbol less_than       = new Symbol(Tag.LESS_THAN     ,"<" );
    public static final Symbol less_equal      = new Symbol(Tag.LESS_EQUAL    ,"<=");
    public static final Symbol diff            = new Symbol(Tag.DIFF          ,"<>");
    public static final Symbol semicolon       = new Symbol(Tag.SEMICOLON     ,";" );
    public static final Symbol comma           = new Symbol(Tag.COMMA         ,"," );
    public static final Symbol equal           = new Symbol(Tag.EQUAL         ,"=" );
    public static final Symbol sum             = new Symbol(Tag.SUM           ,"+" );
    public static final Symbol minus           = new Symbol(Tag.MINUS         ,"-" );
    public static final Symbol mult            = new Symbol(Tag.MULT          ,"*" );
    public static final Symbol div             = new Symbol(Tag.DIV           ,"/" );
    public static final Symbol open_par        = new Symbol(Tag.OPEN_PAR      ,"(" );
    public static final Symbol close_par       = new Symbol(Tag.CLOSE_PAR     ,")" );
    public static final Symbol comment         = new Symbol(Tag.COMMENT       ,"" );

    // palavras chave
    public static final Symbol start           = new Symbol(Tag.START         ,"start" );
    public static final Symbol exit            = new Symbol(Tag.EXIT          ,"exit" );
    public static final Symbol int_type        = new Symbol(Tag.INT           ,"int" );
    public static final Symbol float_type      = new Symbol(Tag.FLOAT         ,"float" );
    public static final Symbol string_type     = new Symbol(Tag.STRING        ,"string" );
    public static final Symbol if_cond         = new Symbol(Tag.IF            ,"if" );
    public static final Symbol then_cond       = new Symbol(Tag.THEN          ,"then" );
    public static final Symbol else_cond       = new Symbol(Tag.ELSE          ,"else" );
    public static final Symbol do_cond         = new Symbol(Tag.DO            ,"do" );
    public static final Symbol while_cond      = new Symbol(Tag.WHILE         ,"while" );
    public static final Symbol scan            = new Symbol(Tag.SCAN          ,"scan" );
    public static final Symbol print           = new Symbol(Tag.PRINT         ,"print" );
    public static final Symbol not             = new Symbol(Tag.NOT           ,"not" );
    public static final Symbol or              = new Symbol(Tag.OR            ,"or" );
    public static final Symbol and             = new Symbol(Tag.AND           ,"and" );
    public static final Symbol end             = new Symbol(Tag.END           ,"end" );
    
    public Symbol(String tag,String lexeme){
        super(tag);
        this.lexeme = lexeme;
    }
    
    
    public String getLexeme(){
        return this.lexeme;
    }
    

}
