package payrollTaxCalculator;

import java.io.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//making the excel file
public class Workbook{
	
	void createFile(String fName,String lName, double salary, double hour, double hRate,double oTime,double oTimeRate,
					String mStatus,double suta, double futa, double fTax, double sTax, double socTax, double medTax,
					double gPay,double nPay, double uDues, String spf, double pYtd, String d, String f){
		
		try (XSSFWorkbook workbook = new XSSFWorkbook()){
			
			FileOutputStream out = new FileOutputStream(new File(d + ":\\" + f + ".xlsx"));
			XSSFSheet Spreadsheet = workbook.createSheet("Employee");
			CellStyle style;
 			
			
			style = workbook.createCellStyle();
			style.setDataFormat((short)0x7);
		
		
			
			Spreadsheet.setColumnWidth(0, 1800);
			
			
			//labels for first row
			Row row0 = Spreadsheet.createRow(0);
			
			Cell cellA = row0.createCell(0);
			Cell cellB = row0.createCell(1);
			Cell cellC = row0.createCell(2);
			Cell cellD = row0.createCell(3);
			Cell cellE = row0.createCell(4);
			Cell cellF = row0.createCell(5);
			Cell cellG = row0.createCell(6);
			Cell cellH = row0.createCell(7);
			Cell cellI = row0.createCell(8);
			Cell cellJ = row0.createCell(9);
			Cell cellK = row0.createCell(10);
			Cell cellL = row0.createCell(11);
			Cell cellM = row0.createCell(12);
			Cell cellN = row0.createCell(13);
			Cell cellO = row0.createCell(14);
			Cell cellP = row0.createCell(15);
			Cell cellQ = row0.createCell(16);
			Cell cellR = row0.createCell(17);
			Cell cellS = row0.createCell(18);
			Cell cellT = row0.createCell(19);
			
			cellA.setCellValue("Last Name");
			cellB.setCellValue("First Name");
			cellC.setCellValue("Prior Earnings");
			cellD.setCellValue("W-4 Allowance");
			cellE.setCellValue("Salary");
			cellF.setCellValue("Hours");
			cellG.setCellValue("Hourly Rate");
			cellH.setCellValue("Overtime Hours");
			cellI.setCellValue("Overtime Rate");
			cellJ.setCellValue("Salary Pay Frequency");
			cellK.setCellValue("Union Dues");
			cellL.setCellValue("SUTA");
			cellM.setCellValue("FUTA");
			cellN.setCellValue("FIT");
			cellO.setCellValue("SIT");
			cellP.setCellValue("OASDI");
			cellQ.setCellValue("Medicare");
			cellR.setCellValue("Net Pay");
			cellS.setCellValue("Gross Pay");
			cellT.setCellValue("Current Earnings");
			
			
			
			
			// fill in second row with processed data
			Row row1 = Spreadsheet.createRow(1);
			
			Cell cellA1 = row1.createCell(0);
			Cell cellB1 = row1.createCell(1);
			Cell cellC1 = row1.createCell(2);
			Cell cellD1 = row1.createCell(3);
			Cell cellE1 = row1.createCell(4);
			Cell cellF1 = row1.createCell(5);
			Cell cellG1 = row1.createCell(6);
			Cell cellH1 = row1.createCell(7);
			Cell cellI1 = row1.createCell(8);
			Cell cellJ1 = row1.createCell(9);
			Cell cellK1 = row1.createCell(10);
			Cell cellL1 = row1.createCell(11);
			Cell cellM1 = row1.createCell(12);
			Cell cellN1 = row1.createCell(13);
			Cell cellO1 = row1.createCell(14);
			Cell cellP1 = row1.createCell(15);
			Cell cellQ1 = row1.createCell(16);
			Cell cellR1 = row1.createCell(17);
			Cell cellS1 = row1.createCell(18);
			Cell cellT1 = row1.createCell(19);
			
			
			cellA1.setCellValue(lName);
			cellB1.setCellValue(fName);
			cellC1.setCellValue(pYtd);
			cellD1.setCellValue(mStatus);
			cellE1.setCellValue(salary);
			cellF1.setCellValue(hour);
			cellG1.setCellValue(hRate);
			cellH1.setCellValue(oTime);
			cellI1.setCellValue(oTimeRate);
			cellJ1.setCellValue(spf);
			cellK1.setCellValue(uDues);
			cellL1.setCellValue(suta);
			cellM1.setCellValue(futa);
			cellN1.setCellValue(fTax);
			cellO1.setCellValue(sTax);
			cellP1.setCellValue(socTax);
			cellQ1.setCellValue(medTax);
			cellR1.setCellValue(nPay);
			cellS1.setCellValue(gPay);
			cellT1.setCellValue(gPay+pYtd);
			
			//formats the cell to currency form
			cellC1.setCellStyle(style);
			cellE1.setCellStyle(style);
			cellG1.setCellStyle(style);
			cellI1.setCellStyle(style);
			cellK1.setCellStyle(style);
			cellL1.setCellStyle(style);
			cellM1.setCellStyle(style);
			cellN1.setCellStyle(style);
			cellO1.setCellStyle(style);
			cellP1.setCellStyle(style);
			cellQ1.setCellStyle(style);
			cellR1.setCellStyle(style);
			cellS1.setCellStyle(style);
			cellT1.setCellStyle(style);
		
		
			workbook.write(out);
			out.close();
		}
		
		catch (Exception e){ System.out.println(e);}
		
		System.out.println("Excel File Created");
	}
}