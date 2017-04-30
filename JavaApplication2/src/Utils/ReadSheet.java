/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Joab
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.io.InputStream;
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
import org.apache.commons.io.FilenameUtils;

public class ReadSheet {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    
    static HSSFRow row;
    
    public static void ReadSheet(String arquivo) throws Exception
    {
        File filename = new File(arquivo);
        FileInputStream isr = new FileInputStream(filename);
        Workbook workbook;
        if (FilenameUtils.getExtension(arquivo).equalsIgnoreCase("xls")) {

        workbook = new HSSFWorkbook(new FileInputStream(arquivo));

        } else if (FilenameUtils.getExtension(arquivo).equalsIgnoreCase("xlsx")) {

         workbook = new XSSFWorkbook(new FileInputStream(arquivo));

        } else {

        throw new IllegalArgumentException(arquivo +"Arquivo não é do tipo excel");

    }
        Sheet sheet = workbook.getSheetAt(0);  
        Iterator<Row> rowItr = sheet.rowIterator();
        
        while (rowItr.hasNext()){
            row = (HSSFRow) rowItr.next();
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
