package one_to_many_bi.dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_bi.dto.Item;
import one_to_many_bi.dto.MedOrder;

public class InsertItem {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
			
		Item item = new Item();
		item.setItem_name("DOLO 650");
		item.setOrdered_person_name("Vaibhav");
		
		MedOrder medOrder1 = new MedOrder();
		medOrder1.setName("Hosptail");
		medOrder1.setOrderedtime(LocalTime.now());
		medOrder1.setItem(item);
		
		MedOrder medOrder2 = new MedOrder();
		medOrder2.setName("Pakka_shop");
		medOrder2.setOrderedtime(LocalTime.now());
		medOrder2.setItem(item);
		
		MedOrder medOrder3 = new MedOrder();
		medOrder3.setName("vinod_shop");
		medOrder3.setOrderedtime(LocalTime.now());
		medOrder3.setItem(item);
		
		List<MedOrder> items = new ArrayList<MedOrder>();
		items.add(medOrder1);
		items.add(medOrder2);
		items.add(medOrder3);
		
		item.setMedOrder(items);
		
		entityTransaction.begin();
//		entityManager.persist(medOrder1);
//		entityManager.persist(medOrder2);
//		entityManager.persist(medOrder3);
		entityManager.persist(item);
		entityTransaction.commit();
	}
}
