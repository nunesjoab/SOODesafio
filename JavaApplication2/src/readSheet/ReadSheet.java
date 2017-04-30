/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readSheet;

/**
 *
 * @author Joab
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;


public class ReadSheet {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    
    static XSSFRow row;
    
    public static void main(String[] args) throws Exception
    {
        File filename = new File("C://Users/Joab/Desktop/jogadores_RG_RA.xlsx");
        FileInputStream isr = new FileInputStream(filename);

        Workbook book1 = new XSSFWorkbook(isr);
        Sheet sheet = book1.getSheetAt(0);  
        Iterator<Row> rowItr = sheet.rowIterator();
        
        while (rowItr.hasNext()){
            row = (XSSFRow) rowItr.next();
            Iterator < Cell > cellIterator = row.cellIterator();
            while ( cellIterator.hasNext())
            {
            Cell cell = cellIterator.next();
            switch (cell.getCellType())
            {
            case Cell.CELL_TYPE_NUMERIC:
            System.out.print(
            cell.getNumericCellValue() + " \t\t " );
            break;
            case Cell.CELL_TYPE_STRING:
            System.out.print(
            cell.getStringCellValue() + " \t\t " );
            break;
            }
            }
            System.out.println();
            }
            isr.close();
    }
    
}
