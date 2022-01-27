package com.ty.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetoone.dto.Invoice;
import com.ty.onetoone.dto.Item;

public class ItemInvoiceDao {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("onetoone");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		return entityManager;
	}

	public void save(Invoice invoice,Item item)	{
		entityManager=getEntityManager();
		entityTransaction.begin();
		entityManager.persist(item);
		entityManager.persist(invoice);
		entityTransaction.commit();
	}

	public Invoice getInvoice(int id) {
		entityManager=getEntityManager();
		Invoice invoice=entityManager.find(Invoice.class, id);
		return invoice;
	}

	public Item getItem(int id) {
		entityManager=getEntityManager();
		Item item=entityManager.find(Item.class, id);
		return item;
	}

	public void updateInvoice(Invoice invoice) {
		entityManager=getEntityManager();
		entityTransaction.begin();
		entityManager.merge(invoice);
		entityTransaction.commit();
	}

	public void updateItem(Item item) {
		entityManager=getEntityManager();
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
	}
	public void deleteInvoiceItem(int id) {
		entityManager=getEntityManager();
		entityTransaction.begin();
		Invoice invoice=entityManager.find(Invoice.class,id);
		if(invoice != null) {
			Item item=invoice.getItem();
			entityManager.remove(invoice);
			if(item != null) {
				entityManager.remove(item);
			}
			entityTransaction.commit();
		}
	}

//	public void deleteItem(int id) {
//		entityManager=getEntityManager();
//		entityTransaction.begin();
//		Invoice invoice=entityManager.find(Invoice.class,id);
//		if(invoice != null) {
//			Item item=invoice.getItem();
//			entityManager.remove(invoice);
//			if(item != null) {
//				entityManager.remove(item);
//			}
//			entityTransaction.commit();
//		}
//	}

}
