package com.consMang.common.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class DataProvider  {
	protected List<String> header;
	private ExcelReader reader;
	private Sheet sheet;
	private Iterator<Row> rows;
	private int headerIndex;
	DataFormatter objDefaultFormat =null;
	FormulaEvaluator objFormulaEvaluator = null;
	
	public DataProvider( ExcelReader reader,int headerIndex)throws Exception{
		objDefaultFormat = new DataFormatter();
	try{	this.reader=reader;
		this.headerIndex=headerIndex;
		this.sheet=this.reader.getSheetAt(0);
		this.rows=this.sheet.iterator();
		this.populateHeaders();}
	catch(Exception ex){
		throw new Exception("EXCEL_ERROR");
	}
	
	}
	public DataProvider( ExcelReader reader,int headerIndex,String sheetName)throws Exception{
		objDefaultFormat = new DataFormatter();
		this.reader=reader;
		this.headerIndex=headerIndex;
		try{
		this.sheet=this.reader.getSheet( sheetName);
		this.rows=this.sheet.iterator();
		this.populateHeaders();
		}catch(Exception ex){
			throw new Exception("EXCEL_ERROR");
		}
	
	}
	
	private void populateHeaders(){
		int num=0;

		while(rows.hasNext()){
			if(num<this.headerIndex){
				rows.next();
			}else{
				Row row=rows.next();
	
				Iterator<Cell> cells=row.iterator();
				header=new ArrayList<String>();
				while(cells.hasNext()){
					Cell cell=cells.next();
					String str=cell.getStringCellValue();
					if(str==null)str="XXXX";
					str=str.trim();
					
					this.header.add(str);
					
				}
				break;
			}
			num++;
		}
		
	}
	
	public Map<String, Object> getRow(){
		Map<String, Object> rowData=null;
		int num=0;
		if(this.rows.hasNext()){
			Row row=this.rows.next();
			rowData=new HashMap<String, Object>();
			
			for(int index=0;index<this.header.size();index++){
				Cell cell=row.getCell(index);
				Object ob=getCellValue(cell);
				if(ob!=null && ob.toString().trim().length()>0){
				rowData.put(this.header.get(index), ob);
				num++;
				}
			}
			
			
		}
		if(num>2)
		return rowData;
		else return null;
	}
	
	private Object getCellValue(Cell cell){
		
		Object ob=null;
		if(cell!=null){
	     switch (cell.getCellType()) {
         case Cell.CELL_TYPE_STRING:
             ob=cell.getStringCellValue();
             break;
         case Cell.CELL_TYPE_BOOLEAN:
             ob=cell.getBooleanCellValue();
             break;
         case Cell.CELL_TYPE_NUMERIC:
        	           ob=     new BigDecimal(cell.getNumericCellValue()).toPlainString();
    if(cell instanceof HSSFCell){
    	    	 if (HSSFDateUtil.isCellDateFormatted(cell)) {
    	               
                     ob=    cell.getDateCellValue();
                     if(ob!=null){
        	    		 ob=com.consMang.common.util.DateUtil.getDateString((Date)ob);
        	    	 }
                 }
    	     } else   if(cell instanceof XSSFCell){
    	    	 XSSFCell xc=(XSSFCell)cell;
    	    	 if(DateUtil.isCellDateFormatted(xc)){
    	    	ob= xc.getDateCellValue();
    	    	 if(ob!=null){
    	    		 ob=com.consMang.common.util.DateUtil.getDateString((Date)ob);
    	    	 }}
    	     }
             break;
             default:
             ob=cell.getStringCellValue();
	     }
	     
	   
            
     }
		return ob;
	}

	public void close() {
		try{
		this.reader.close();
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}
}
