package com.sl.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App 
{
	public static void main(String[] args) 
	{
		Product product;
		List<Product> products = new ArrayList<>();
		try
		{
			FileInputStream file = new FileInputStream("c:/temp/bamba.xlsx");
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				String[] cols = new String[256];
				int c = 0;
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType()) 
					{
						case NUMERIC:
							//System.out.print(cell.getNumericCellValue() + "\t");
							cols[c++] = Double.toString(cell.getNumericCellValue());
							break;
						case STRING:
							//System.out.print(cell.getStringCellValue() + "\t");
							cols[c++] = cell.getStringCellValue();
							break;
						default:
							throw new IllegalStateException("Unexpected value: " + cell.getCellType());
					}
				}
				product = new Product(cols[0], cols[2], cols[14],cols[15],cols[16],cols[17],cols[18],cols[19],cols[20],cols[21],cols[22]);
				products.add(product);
				System.out.println(product.toString());
				System.out.println("");
			}
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		PrintWriter writer;
		try {
			writer = new PrintWriter("c:/temp/saida.txt", "UTF-8");
			int l = 0;
			for (Product p : products) {
				l++;
				if (l > 2) writer.println(p);
			}
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}