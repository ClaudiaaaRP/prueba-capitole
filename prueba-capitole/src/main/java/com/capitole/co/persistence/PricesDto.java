package com.capitole.co.persistence;

import java.time.OffsetDateTime;

public class PricesDto {
		
	private Integer brandId;

	
	private OffsetDateTime date;
	
	private Float price;

	private Integer priceList;
	
	public Integer getPriceList() {
		return priceList;
	}


	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	private Integer productId;
	
	public PricesDto() {
		
	}
	
	
	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public OffsetDateTime getDate() {
		return date;
	}

	public void setDate(OffsetDateTime date) {
		this.date = date;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	
}
