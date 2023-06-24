package pruebas;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Iterator;

public class excel {

    public static String exceldoc() throws Exception {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/starter/Task/Libro1.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet worksheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = worksheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getCell(1).getStringCellValue().equalsIgnoreCase("First Name")) {
                    if (row.getCell(1)!=null) {
                        if (row.getCell(1).getCellType() == CellType.STRING) {
                            return String.valueOf(row.getCell(1).getStringCellValue());
                        } else {
                            return row.getCell(1).getStringCellValue();
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve value from test data xlsx \n" + e.getMessage());
        } finally {
            fileInputStream.close();
        }
        return null;
    }

}
