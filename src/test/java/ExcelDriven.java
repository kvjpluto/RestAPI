import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.IRunElement;

public class ExcelDriven {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("G:\\WorkLearn\\ExcelData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int Sheets=workbook.getNumberOfSheets();
		for(int i=0;i<Sheets;i++){
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData")){
				System.out.println("Sheet Name:"+workbook.getSheetName(i));
				
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> row=sheet.iterator();
				Row firstrow=row.next();
				Iterator<Cell> cell=firstrow.cellIterator();
				int column=0,k=0;
				while(cell.hasNext()){
					Cell cellvalue=cell.next();
					if(cellvalue.getStringCellValue().equalsIgnoreCase("TestCase")){
						column=k;
					}
					k++;
				}
				System.out.println(column);
				while(row.hasNext()){
					Row data=row.next();
					if(data.getCell(column).getStringCellValue().equalsIgnoreCase("Login")){
						Iterator<Cell> cd=data.cellIterator();
						while(cd.hasNext()){
							Cell c=cd.next();
							if(c.getCellTypeEnum()==CellType.STRING){
								System.out.println(c.getStringCellValue());
							}
							else{
								System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
					//System.out.println(data.getCell(column).getStringCellValue());
				}
			}
		}
	}
	
}
