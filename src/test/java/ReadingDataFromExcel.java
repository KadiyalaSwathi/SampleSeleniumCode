import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingDataFromExcel {

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir")+ File.separator+"TestData.xlsx";
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(path));
        Sheet sh = wb.getSheetAt(0);
        int TotalRows = sh.getLastRowNum();
        for(int i=0;i<=TotalRows;i++){
          for(int j=0;j<sh.getRow(i).getLastCellNum();j++) {
              String value = sh.getRow(i).getCell(j).getStringCellValue();
             // String row1 = sh.getRow(i).getCell(0).getStringCellValue();
              //String row2 = sh.getRow(i).getCell(1).getStringCellValue();
              //System.out.println(row1 + " | " + row2);
              System.out.print(value+" ");
          }
          System.out.println(" ");
        }
    }
}
