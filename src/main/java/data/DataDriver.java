package data;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;



public class DataDriver {
    public static  void main(String[] args){
//        getExcelData("H:\\readExcel.xls","test");
    }

    public String Path="H:\\readExcel.xls";
    public String Sheet="test";

    @DataProvider( name= "MyDataProvider")
    public static Object[][] getExcelData() {
//        String excelPath   = "H:\\readExcel.xls";
        String excelPath   = "H:\\readExcel.xls";
//        String excelPath   = "H:\\readExcel.xls";
        String excelSheet  = "test";
        int rowIndex = 0;//定义表格行
        int celIndex = 0;//定义表格列
        Sheet naviSheet = getSheet(excelPath, excelSheet);//取到Excel表格方法（文件路径，表格名称）
        int iLastRowIndex = naviSheet.getLastRowNum(); //取该表格的行标。从0行开始，计算。所以行标会比实际行数小1。中间有空白行也计算在内。直到最后一行数据
        Object excelData[][] = new Object[iLastRowIndex+1][1]; //创建一个Excel多维数组对象
        for (rowIndex = 0; rowIndex <= iLastRowIndex; rowIndex++) {  //第一级循环：行循环，第1行循环到最后一行（即表格行数）
            Row row = naviSheet.getRow(rowIndex);// 获取哪一行的数据。如果是第一次循环，则获取第0行(实际是第1行)的数据
            int lastCelIndex = row.getLastCellNum();//获取所在行的列数
            ArrayList<String> list =  new ArrayList<String>();//定义一个List，用于存放读取的表格数据
            for (celIndex = 0; celIndex < lastCelIndex; celIndex++) { //第二级循环：列循环，第1列循环到最后一列
                Cell cell = getCell(naviSheet, rowIndex, celIndex);//根据行和列，取表格的单元格
                String paramValue = getCellValue(cell);//取单元格的值
                list.add(celIndex,paramValue);//将单元格的值存放到list中
            }
            excelData[rowIndex][0] = list;//直接将list放入数组
        }
        return excelData;
    }

    /**
     * @Title: getSheet
     * @Description: Get the sheet from Excel:从Excel获取表
     * @return: Sheet
     */
    private  static Sheet getSheet(String path, String sheetname){
        InputStream fs = null;
        Sheet naviSheet = null;
        try {
            fs = new FileInputStream(path);//创建一个文件流输入对象
            Workbook wb = WorkbookFactory.create(fs);//创建一个工作表对象
            naviSheet = wb.getSheet(sheetname);//
        }catch(IOException e)
        {
            e.printStackTrace();
        }catch(InvalidFormatException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return naviSheet;
    }

    /**
     * @Title: getSheet
     * @Description: Get the Cell from Excel:从Excel获取单元格
     * @return: Cell
     */
    private static Cell getCell(Sheet sheet, int rowIndex, int columnIndex) {
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }
        Cell cell = row.getCell(columnIndex);
        if (cell == null) {
            cell = row.createCell((short) columnIndex);
        }
        return cell;
    }

    /**
     * @Title: getCellValue
     * @Description: Get the Cell value from Excel:从Excel获取单元格值
     * @return: String
     */
    private static String getCellValue(Cell cell) {
        String arg = "";
        DecimalFormat df = new DecimalFormat("#");
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                arg = (cell == null ? "" : cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                Double dvalue = (cell == null ? 0 : cell.getNumericCellValue());
                arg = String.valueOf(dvalue);
                if(arg.matches("\\d+.[0]*"))
                {
                    int endIndex = arg.indexOf(".");
                    arg = arg.substring(0, endIndex);
                }
                if(arg.matches("^((-?\\d+.?\\d*)[Ee]{1}(\\d+))$"))
                {
                    arg = df.format(dvalue);
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                Boolean bool = (cell == null ? false : cell.getBooleanCellValue());
                arg = bool.toString();
                break;
            case Cell.CELL_TYPE_FORMULA:
                arg = (cell == null ? "" : cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_ERROR:
                arg =  (cell == null ? "" : Byte.toString(cell.getErrorCellValue()));
                break;
            case Cell.CELL_TYPE_BLANK:
                arg = "";
                break;
        }
        return arg;
    }

}