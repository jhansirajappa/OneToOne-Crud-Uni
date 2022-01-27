package com.ty.onetoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoone.dao.ItemInvoiceDao;
import com.ty.onetoone.dto.Invoice;
import com.ty.onetoone.dto.Item;

public class InvoiceController {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("onetoone");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();

//		Item item=new Item();
//		item.setId(2);
//		item.setName("IceCreams");
//		item.setCost(45);
//		item.setQty(10);
//		
//		Invoice invoice=new Invoice();
//		invoice.setId(2);
//		invoice.setName("BLR TYSS");
//		invoice.setBillingAddress("TY-DEF");
//		invoice.setGstNumber("255-225");
//		invoice.setTax(10);
//		invoice.setItem(item);

		
		ItemInvoiceDao itemInvoiceDao=new ItemInvoiceDao();
		itemInvoiceDao.getItem(2);
	}

}
