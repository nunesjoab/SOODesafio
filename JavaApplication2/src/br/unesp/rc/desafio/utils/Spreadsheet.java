/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.desafio.utils;

/**
 *
 * @author Joab
 */

import java.io.File;
import org.apache.commons.io.FilenameUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;


public class Spreadsheet {
    
    static HSSFRow row;
    static XSSFRow row1;
    /*
        Private constructor to disable any instances from this class, outside in
    subclasses or inside in any method.
    */
    private Spreadsheet(){
        throw new AssertionError();
    }
    
    /*
    This method receives a string as parameter. This string is the full path
to a xls(x) file. The method choose a method to read according extension.
    */
    
    public static void ChooseSpreadsheetFormat(String fullpath){
        
        
        if (FilenameUtils.getExtension(fullpath).equalsIgnoreCase("xls")) {
            File spreadsheet = new File(fullpath);
            ReadXlsSpreadsheet(spreadsheet);
        } else if (FilenameUtils.getExtension(fullpath).equalsIgnoreCase("xlsx")) {
            File spreadsheet = new File(fullpath);
            ReadXlsxSpreadsheet(spreadsheet);
        } else {
            throw new IllegalArgumentException(fullpath +"Arquivo não é do tipo excel");

        }
    }
    
    public static void ReadXlsSpreadsheet(File spreadsheet){
        
        /*
        Constructing File
        */
        FileInputStream inputStr = null;
        try {
            inputStr = new FileInputStream(spreadsheet);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Spreadsheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Workbook currentSpreadsheetFile = null;
        
        try {
            HSSFRow row;
            currentSpreadsheetFile = new HSSFWorkbook(inputStr);
        } catch (IOException ex) {
            Logger.getLogger(Spreadsheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Sheet sheet = currentSpreadsheetFile.getSheetAt(0);  
        Iterator<Row> rowItr = sheet.rowIterator();
        
        while (rowItr.hasNext()){
            row = (HSSFRow) rowItr.next();
            Iterator < Cell > cellIterator = row.cellIterator();
            while ( cellIterator.hasNext()){
                Cell cell = cellIterator.next();
            
                switch (cell.getCellType()){
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " \t\t " );
                    break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + " \t\t " );
                    break;
                }
            }
            System.out.println();
        }
        try {
            inputStr.close();
        } catch (IOException ex) {
            Logger.getLogger(Spreadsheet.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    
    public static void ReadXlsxSpreadsheet(File spreadsheet){
        
        /*
        Constructing File
        */
        FileInputStream inputStr = null;
        try {
            inputStr = new FileInputStream(spreadsheet);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Spreadsheet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Workbook currentSpreadsheetFile = null;
        
        try {
                XSSFRow row1;
                currentSpreadsheetFile = new XSSFWorkbook(inputStr);
            } catch (IOException ex) {
                Logger.getLogger(Spreadsheet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        Sheet sheet = currentSpreadsheetFile.getSheetAt(0);  
        Iterator<Row> rowItr = sheet.rowIterator();
        
        while (rowItr.hasNext()){
            row1 = (XSSFRow) rowItr.next();
            Iterator < Cell > cellIterator = row1.cellIterator();
            while ( cellIterator.hasNext()){
                Cell cell = cellIterator.next();
            
                switch (cell.getCellType()){
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " \t\t " );
                    break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + " \t\t " );
                    break;
                }
            }
            System.out.println();
        }
        try {
            inputStr.close();
        } catch (IOException ex) {
            Logger.getLogger(Spreadsheet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}