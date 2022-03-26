package com.company;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Write {
    public void exp(Calculator calculator, File file) throws IOException
    {
        XSSFWorkbook wb2 = new XSSFWorkbook();
        XSSFSheet sf = wb2.createSheet("Кузнецов");
        sf.setColumnWidth(0, 6000);
        for(int i=1; i<=3; i++)
        {
            sf.setColumnWidth(i, 4000);
        }
        XSSFRow row0 = sf.createRow(0); //созднание строки
        row0.createCell(1, CellType.STRING).setCellValue("x");
        row0.createCell(2, CellType.STRING).setCellValue("y");
        row0.createCell(3, CellType.STRING).setCellValue("z");
        LinkedHashMap<String, Double[]> lhm = calculator.getLhm();
        Set set = lhm.entrySet();
        Iterator iterator = set.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            XSSFRow row = sf.createRow(i);
            Map.Entry data = (Map.Entry) iterator.next();
            row.createCell(0, CellType.STRING).setCellValue((String) data.getKey());
            for (int j = 0; j < 3; j++) {
                row.createCell(j + 1, CellType.NUMERIC).setCellValue(((Double[]) data.getValue())[j]);
            }
            i++;
        }

        wb2.write(new FileOutputStream(file)); //запись в файл

    }
}
