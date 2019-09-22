/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//package LEX;

/**
 *
 * @author Arthur e Jonathan
 */

public class Lexer {
    
    private File f;
    private FileReader fr;
    private BufferedReader br;
    private int c =0;
    private char ch;
    private char last_ch;

    public Lexer(String fileName) throws FileNotFoundException, IOException {
      this.f = new File(fileName);     //Creation of File Descriptor for input file
      this.fr= new FileReader(f);   //Creation of File Reader object
      this.br= new BufferedReader(fr);
      this.ch = ' ';
      //c =br.read();
      //reservar palavras.
    }

    
}