/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import static br.unesp.rc.desafio.utils.Spreadsheet.ChooseSpreadsheetFormat;
import br.unesp.rc.desafio.visao.Notas;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joab
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        Notas frame = new Notas();
        frame.pack();
        frame.setVisible(true);
        
       
    }
    
}
