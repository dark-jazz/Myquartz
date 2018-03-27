package com.dark.pojo;
/**  作者：darkjazz 
*    日期：2018年3月22日 下午7:32:03
*/
public class Product {
     private String productName;
     private String lowerPrice;
     private String averagePrice;
     private String maxPrice;
     //规格
     private String specs;
     //单位
     private String unit;
     
     //发布日期
     private String date;

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", lowerPrice=" + lowerPrice + ", averagePrice=" + averagePrice
				+ ", maxPrice=" + maxPrice + ", specs=" + specs + ", unit=" + unit + ", date=" + date + "]";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getLowerPrice() {
		return lowerPrice;
	}

	public void setLowerPrice(String lowerPrice) {
		this.lowerPrice = lowerPrice;
	}

	public String getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
