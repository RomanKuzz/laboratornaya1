package com.company;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Read {
    double[][] arr;
    public void imp(File file) throws IOException, InvalidFormatException {

        XSSFWorkbook workbook = new XSSFWorkbook(file); // Создать рабочий лист

        XSSFSheet sheet = workbook.getSheetAt(4); // Получаем строку

        arr = new double[3][sheet.getLastRowNum()]; //масс, получаем последнюю строку на листе
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                arr[i][j - 1] = sheet.getRow(j).getCell(i).getNumericCellValue(); //Возвращаем логическую строку; Получиаем ячейку, представляющую данный столбец и Получаем значение ячейки в виде числа
            }
        }
        workbook.close(); // закрываем книгу

    }
    public double[][] getArr()
    {
        return arr;
    }
}