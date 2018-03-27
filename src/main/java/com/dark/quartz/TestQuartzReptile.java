package com.dark.quartz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.dark.pojo.Product;
import com.dark.util.POItoExcel;

/**  作者：钟宗斌 
*    日期：2018年3月23日 上午10:02:37
*/
public class TestQuartzReptile implements Job{
/*	public static void main(String[] args) throws FileNotFoundException, IOException {
 	   List<Product> list=getInfor("http://www.xinfadi.com.cn/marketanalysis/1/list/1.shtml", 6);
 	   POItoExcel.toExcel(list);
	}*/
	
    
    public static List<Product> getInfor(String url,int maxPage){
 	   List<Product> proList=new ArrayList<Product>();
 	   for(int i=2;i<=maxPage+1;i++){
 	      
 		 try {
 			
				Document doc=Jsoup.connect(url).get();
				Elements table=doc.select(".hq_table");
				Elements tbody=table.select("tbody");
				Elements trList=tbody.select("tr");
				trList.remove(0);
				for(Element tr:trList){
					Elements tdList=tr.select("td");
					Product product=new Product();
					product.setProductName(tdList.get(0).html().toString());
					product.setLowerPrice(tdList.get(1).html().toString());
					product.setAveragePrice(tdList.get(2).html().toString());
					product.setMaxPrice(tdList.get(3).html().toString());
					product.setSpecs(tdList.get(4).html().toString());
					product.setUnit(tdList.get(5).html().toString());
					product.setDate(tdList.get(6).html().toString());
					/*System.out.println(product.toString());*/
					proList.add(product);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		 
 	   
 	   
 	   url="http://www.xinfadi.com.cn/marketanalysis/1/list/"+i+".shtml";
 	   }
 	   System.out.println("爬取前"+maxPage+"成功");
		return proList;
 	   
    }


	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		 List<Product> list=getInfor("http://www.xinfadi.com.cn/marketanalysis/1/list/1.shtml", 6);
	 	   try {
			POItoExcel.toExcel(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
