package com.sp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sp.model.Transaction;



public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

	public List<Transaction> findByBuyerId(int id);
	public Optional<Transaction> findBySellerId(int id);
	public List<Transaction> findAll();
	public List<Transaction> findByPrice(int price);
	public List<Transaction> findByTransactionDate(Date date);
	
}

