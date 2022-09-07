package com.capitole.co.persistence;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "prices")
public class Prices implements Serializable{

	@EmbeddedId
	private PricesPK id;

	@Column(name = "start_date")
	private OffsetDateTime startDate;

	@Column(name = "end_date")
	private OffsetDateTime endDate;

	@Column(name = "price_list")
	private Integer priceList;

	@Column(name = "price")
	private Float price;

	@Column(name = "curr")
	private String curr;

	public Prices() {
	}

	public PricesPK getId() {
		return id;
	}

	public void setId(PricesPK id) {
		this.id = id;
	}

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public OffsetDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}



}
