package com.dark.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dark.pojo.Product;

/**  作者：钟宗斌 
*    日期：2018年3月22日 下午8:00:33
*/
public class POItoExcel {
     public static void main(String[] args) {
		
	}
	public static void toExcel(List<Product> list) throws FileNotFoundException, IOException{
		 
        //新建文档   
        XSSFWorkbook workBook=new XSSFWorkbook();
        
        //创建表
        XSSFSheet sheet=workBook.createSheet();
        
           //合并标的标题
      		CellRangeAddress cra=new CellRangeAddress(0,1, 0, 6);
      		sheet.addMergedRegion(cra);
      		//显示的文本为左上角的内容
      		Row row2=sheet.createRow(0);
      		Cell cell=row2.createCell(0);
      		cell.setCellValue("商品价格表");
      		//设置单元格的格式
      		CellStyle cs=workBook.createCellStyle();
      		cs.setAlignment(HorizontalAlignment.CENTER);
      		cs.setVerticalAlignment(VerticalAlignment.CENTER);
      		cs.setFillBackgroundColor((short) 59);
      	    cell.setCellStyle(cs);
      		
      		
      		//表头
      		Row row=sheet.createRow(2);
      		
      		Cell cell11=row.createCell(0);
      		cell11.setCellValue("品名");
      		Cell cell22=row.createCell(1);
      		cell22.setCellValue("最低价");
      		Cell cell33=row.createCell(2);
      		cell33.setCellValue("平均价");
      		Cell cell44=row.createCell(3);
      		cell44.setCellValue("最高价");
      		Cell cell55=row.createCell(4);
      		cell55.setCellValue("规格");
      		Cell cell66=row.createCell(5);
      		cell66.setCellValue("单位");
      		Cell cell77=row.createCell(6);
      		cell77.setCellValue("发布日期");
      	    //表中的数据
        
        
        
        
        
        
        
        
        
        for(int i=0;i<list.size();i++){
        //创建行
        XSSFRow row4=sheet.createRow(i+3);
      
      
        //创建单元格
        XSSFCell cell1=row4.createCell(0);
        XSSFCell cell2=row4.createCell(1);
        XSSFCell cell3=row4.createCell(2);
        XSSFCell cell4=row4.createCell(3);
        XSSFCell cell5=row4.createCell(4);
        XSSFCell cell6=row4.createCell(5);
        XSSFCell cell7=row4.createCell(6);
        	//在单元格中写入数据
        cell1.setCellValue(list.get(i).getProductName());
        cell2.setCellValue(list.get(i).getLowerPrice());
        cell3.setCellValue(list.get(i).getAveragePrice());
        cell4.setCellValue(list.get(i).getMaxPrice());
        cell5.setCellValue(list.get(i).getSpecs());
        cell6.setCellValue(list.get(i).getUnit());
        cell7.setCellValue(list.get(i).getDate());
        }
         //把这个文档写入文件,并且按规则命名
     /*   UUID name=UUID.randomUUID();
        String name1=name.toString();*/
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        String name=dateFormat.format(new Date());
        workBook.write(new FileOutputStream(new File("D:\\钟宗斌\\java第五阶段\\爬虫\\poi目录\\"+name+"product.xlsx")) );
        System.out.println("写入excel完毕");
        //关闭流
        workBook.close();
		
		
		
	}
     
     
}
