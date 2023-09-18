package com.academy.muharremkulak.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    private XSSFWorkbook workbook;  // creates am object from excel document
    private XSSFSheet workSheet;   // creates object from Excel sheet


    public ExcelReader(String filePath, String sheetName){
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            this.workbook = new XSSFWorkbook(fis); //document object
            this.workSheet = workbook.getSheet(sheetName);
            workbook.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object[][] getData(){

        int rows = getNumberOfRows();
        int cols = workSheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][1];

        for(int i = 0; i < rows; i++){
            XSSFCell cell = workSheet.getRow(i+1).getCell(0);
            if (cell != null){
                if (!cell.toString().equalsIgnoreCase("y")) continue;
            }
            Map<String,String> map = new HashMap<>();
            for (int j = 0; j < cols; j++) {
                XSSFCell cll = workSheet.getRow(i+1).getCell(j);
                map.put(workSheet.getRow(0).getCell(j).toString(),
                        cll == null ? "" : cll.toString());
            }
            data[i][0] = map;
        }
        return data;
    }

    private int getNumberOfRows(){
        int counter = 0;
        int rows = workSheet.getLastRowNum();
        for (int i = 0; i < rows; i++) {
            XSSFCell cell = workSheet.getRow(i+1).getCell(0);
            if (cell != null){
                if (cell.toString().equalsIgnoreCase("y")){
                    counter++;
                }
            }
        }
        return counter;
    }

}
