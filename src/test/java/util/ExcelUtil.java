package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//本类主要实现文件扩展为.xlsx的 Excel文件操作
public class ExcelUtil {
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	// 设定要操作Excel的文件路径和Excel文件中的Sheet名称
	// 在读写Excel的时候，均需要先调用此方法，设定要操作的Excel文件路径和要操作的Sheet名称
	public static void setExcelFile(String Path, String SheetName) {
		FileInputStream ExcelFile;
		try {
			// 实例化Excel文件的FileInputStream对象
			ExcelFile = new FileInputStream(Path);
			// 实例化Excel文件的XSSFWorkbook对象
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			/**
			 * 实例化XSSFSheet对象，制定Excel文件中的Sheet名称，后续用于Sheet中行、列和单元格的操作
			 */
			excelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 读取Excel文件指定单元格的函数
	public static String getCellData(int RowNum, int ColNum) {
		try {
			// 通过函数参数指定单元格的行号和列好，获取指定的单元格对象
			Cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			/**
			 * 如果单元格的内容为字符串类型，则使用getStringCellValue方法获取
			 * 如果单元格的内容为数字类型，则使用getNumericCellValue方法获取
			 * 注意getNumericCellValue返回值为double，转换字符串类型必须
			 * 在Cell.getNumericCellValue前增加""，用于强制转换double类型到
			 * String类型，不加""则会抛出double类型无法转换到String类型的异常
			 */
			String CellData = Cell.getCellType() == XSSFCell.CELL_TYPE_STRING ? Cell
					.getStringCellValue() + ""
					: String.valueOf(Math.round(Cell.getNumericCellValue()));
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	/*
	// 在Excel文件的执行单元格中写入数据
	public static void setCellData(int RowNum, int ColNum, String Result) {
		try {
			// 获取Excel文件中的行对象
			Row = excelWSheet.getRow(RowNum);
			// 如果单元格为空，则返回null
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {
				// 当单元格对象是Null的时候，则创建单元格
				// 如果单元格为空，无法直接调用单元格对象的setCellValue方法设定单元格的值
				Cell = Row.createCell(ColNum);
				// 创建单元格后可以调用单元格对象的setCellValue方法设定单元格的值
				Cell.setCellValue(Result);
			}
		} catch (Exception e) {
			// 单元格中有内容，则可以直接调用单元格对象的setCellValue方法设定单元格的值
			Cell.setCellValue(Result);
		}

		// 实例化写入Excel文件的文件输出流对象
		try {
			FileOutputStream fileOut = new FileOutputStream(
					Constant.TestDataExcelFilePath);
			// 将内容写入到Excel文件中
			ExcelWBook.write(fileOut);
			// 强制刷新新写入文件
			fileOut.flush();
			// 关闭文件输出对象
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 从Excel文件获取测试数据的静态方法
	public static Object[][] getTestData(String excelFilePath, String sheetName)
			throws Exception {
		// 根据参数传入的数据文件路径和文件名称，组合出Excel数据文件的绝对路径
		// 声明一个File文件对象
		File file = new File(excelFilePath);

		// 创建FileInputStream对象用于读取Excel文件
		FileInputStream inputStream = new FileInputStream(file);

		// 声明Workbook对象
		Workbook Workbook = null;

		// 获取文件名参数的扩展名，判断是.xlsx文件还是.xls文件
		String fileExtensionName = excelFilePath.substring(excelFilePath
				.indexOf("."));

		// 判断文件类型如果是.xlsx，则使用XSSFWorkbook对象进行实例化
		// 如果是.xls，则使用SSFWorkbook对象进行实例化
		if (fileExtensionName.equals(".xlsx")) {
			Workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			Workbook = new HSSFWorkbook(inputStream);
		}
		// 通过sheetName参数，生成Sheet对象
		Sheet Sheet = Workbook.getSheet(sheetName);

		// 获取Excel数据文件Sheet1中数据的行数，getLastRowNum方法获取数据的最后行号
		// getFirstRowNum方法获取数据的第一行行号，相减之后算出数据的行数

	}*/
}
