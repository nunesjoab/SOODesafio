/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import br.unesp.rc.desafio.utils.Spreadsheet.*;
import static br.unesp.rc.desafio.utils.Spreadsheet.ChooseSpreadsheetFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

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
        
        System.out.println("Digite o caminho do arquivo: ");
        Scanner in =new Scanner(System.in);
        String input = in.nextLine();
        
        ChooseSpreadsheetFormat(input);
        
        
    }
    
}
