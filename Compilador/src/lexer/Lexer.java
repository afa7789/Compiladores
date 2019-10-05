package lexer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Hashtable;

//package LEX;

/**
 *
 * @author Arthur e Jonathan
 */

public class Lexer {
    
    private File f;
    private FileReader fr;
    private BufferedReader br;
    private static int line_count =0;
    private char ch =' ';
    
    private Hashtable words = new Hashtable();
    
    public Lexer(String fileName) throws FileNotFoundException, IOException {
      try{
        f = new File(fileName);  
        fr = new FileReader(f);
        br= new BufferedReader(fr);
      }catch(FileNotFoundException e){
          System.out.println("Arquivo não encontrado");
          throw e;
       }  

      ch = ' ';
      //c =br.read();
      //reservar palavras.
      reserve(new Word(Tag.AND,"and"));
      reserve(new Word(Tag.OR,"or"));
      reserve(new Word(Tag.NOT,"not"));
      reserve(new Word(Tag.START,"start"));
      reserve(new Word(Tag.END,"end"));
      reserve(new Word(Tag.EXIT,"exit"));
      reserve(new Word(Tag.INT,"int"));
      reserve(new Word(Tag.FLOAT,"float"));
      reserve(new Word(Tag.STRING,"string"));
      reserve(new Word(Tag.IF,"if"));
      reserve(new Word(Tag.ELSE,"else"));
      reserve(new Word(Tag.THEN,"then"));
      reserve(new Word(Tag.DO,"do"));
      reserve(new Word(Tag.WHILE,"while"));
      reserve(new Word(Tag.SCAN,"scan"));
      reserve(new Word(Tag.PRINT,"print"));
      
    }
    
    private void reserve(Word w){
        words.put(w.getLexeme(), w);
    }
    
    private void readch() throws IOException{
        ch = (char) fr.read();
    }
    
    private boolean readchisc(char c) throws IOException{
       readch();
       if (ch != c) return false;
       ch = ' ';
       return true;  
    }
    
    public Token scan() throws IOException{
        readch();
        for(;;readch()){
            if( (ch == ' ')|| (ch == 32) || (ch =='\t') || (ch == '\r') || (ch == '\b')) continue;
            else if ( ch == '\n') line_count++;
            else break;
        }
        StringBuilder sb;
        switch(ch){
            case ',':
                return Symbol.comma;
            case '“':
                sb = new StringBuilder();
                readch();
                do{
                    sb.append(ch);
                    readch();
                    if(ch == -1 || ch == 65535){
                        return new Word(Tag.UNKNOWN,sb.toString());
                    }
                }while(ch != '”');
                return new Word(Tag.LITERAL,sb.toString());
            case '"':
                sb = new StringBuilder();
                readch();
                do{
                    sb.append(ch);
                    readch();
                    if(ch == -1 || ch == 65535){
                        return new Word(Tag.UNKNOWN,sb.toString());
                    }
                }while(ch != '"');
                return new Word(Tag.LITERAL,sb.toString());
            case ';':
                return Symbol.semicolon;
            case '.':
                readch();
                if(Character.isDigit(ch)){
                    int counter =0;
                    float valueFF=0;
                    do{
                        counter--;
                        valueFF += Math.pow(10,counter)*Character.digit(ch,10);
                        readch();
                    }while(Character.isDigit(ch));
                }
                
                return Symbol.dot;
            case '/':
                readch();
                if( ch =='*'){
                    sb = new StringBuilder();
                    readch();
                    do{
                        sb.append(ch);
                        readch();
                        if(ch == '*'){
                            Character aux = ch;
                            readch();
                            if(ch == '/')
                                return new Word(Tag.COMMENT,sb.toString());
                            else
                                sb.append(aux);
                        }
                    }while(ch != '"');
                }else if(ch == '/'){
                    sb = new StringBuilder();
                    readch();
                    do{
                        sb.append(ch);
                        readch();
                    }while(ch != '\n');
                    line_count++;
                    return new Word(Tag.COMMENT,sb.toString());
                }              
                return Symbol.div;
            case '*':
                return Symbol.mult;
            case '+':
                return Symbol.sum;
            case '-':
                return Symbol.minus;
            case '(':
                return Symbol.open_par;
            case ')':
                return Symbol.close_par;

            case '=':
                if(readchisc('='))
                    return Symbol.comparation;
                else
                    return Symbol.equal;     
            case '<':
                readch();
                if(ch == '>')
                    return Symbol.diff;
                else if(ch == '=')
                    return Symbol.less_equal;
                return Symbol.less_than;
            
            case '>':
                if(readchisc('='))
                    return Symbol.greather_equal;
                return Symbol.greather_than;
        }
        
        if(Character.isDigit(ch)){
            int value=0;
            do{
                value = 10*value + Character.digit(ch,10);
                readch();
            }while(Character.isDigit(ch));
            if(ch=='.'){
                float valueF = value;
                float valueF2 = 0;
                int counter =0;
                readch();
                do{
                    counter--;
                    valueF2 += Math.pow(10,counter)*Character.digit(ch,10);
                    readch();
                }while(Character.isDigit(ch));
                valueF+=valueF2;
                return new FloatConst(valueF,Tag.FLOATING);
            }
            return new IntegerConst(value,Tag.INTEGER);                
        }
            
        
        if(Character.isLetter(ch)){
            sb = new StringBuilder();
            do{
                sb.append(ch);
                readch();
            }while(Character.isLetterOrDigit(ch));

            String s = sb.toString();
            Word w = (Word) words.get(s);
            if (w != null)
                return w;
            w = new Word(s,Tag.ID);
            words.put(s, w);
            return w;
        } 
                
       // System.out.println((int)ch);
        
        if(ch==-1 || ch == 65535){
            return new Token(Tag.UNKNOWN,"EOF");
        }
        
        Token t = new Token(String.valueOf(ch));
        ch = ' ';
        return  t;
    }
    
    public int getLineCount(){
        return line_count;
    }
}