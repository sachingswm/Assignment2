package com.example.assignment2.helper;

import com.example.assignment2.entity.User;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class FileHandler {
    public static List<User> convertFileTOListOfUser(MultipartFile multipartFile)throws Exception
    {
        List<User> users=new ArrayList<>();
        File file=new File(multipartFile.getOriginalFilename());
        file.createNewFile();
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        FileInputStream fileInputStream=new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(file);
        Iterator<Sheet> sheetIterator= workbook.sheetIterator();
        Sheet sheet=workbook.getSheetAt(0);
        DataFormatter dataFormatter=new DataFormatter();
        Iterator<Row> rowIterator=sheet.rowIterator();
        while(rowIterator.hasNext())
        {
            Row row=rowIterator.next();
            Iterator<Cell> cellIterator=row.cellIterator();
            User user=new User();
            int count=0;
            while(cellIterator.hasNext())
            {

                Cell cell=cellIterator.next();
                String cellValue=dataFormatter.formatCellValue(cell);
                if(count==0)
                {
                    user.setId(Long.parseLong(cellValue));
                    count++;
                }
                else
                {
                    user.setName(cellValue);
                }
            }
            users.add(user);

        }
        workbook.close();
        return users;
    }

}
