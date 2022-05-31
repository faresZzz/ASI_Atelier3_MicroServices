package com.sp.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Transaction {

	
	@Id
	@GeneratedValue
	private int id;
	
	private int buyerId;
	private int sellerId;
	private int cardId;
	private int price;
	
	@Temporal(TemporalType.DATE)
	private Date transactionDate;
	
	@Temporal(TemporalType.TIME)
	private Date transactionTime;
	public Transaction(int buyerId, int sellerId, int cardId, int price)
	{
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.cardId = cardId;
		this.price = price;
		this.transactionDate = new Date();
		this.transactionTime = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", buyerId=" + buyerId + ", sellerId=" + sellerId + ", price=" + price
				+ ", transactionDate=" + transactionDate + "]";
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
	
	
}
