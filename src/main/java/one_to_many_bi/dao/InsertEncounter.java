package one_to_many_bi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_many_bi.dto.Encounter;
import one_to_many_bi.dto.Person;

public class InsertEncounter {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
			
		Encounter encounter = new Encounter();
		encounter.setId(1);
		encounter.setName("I_am_Pravven");
		
		Person person = new Person();
		person.setName("Vaibhav");
		person.setNo(997224397);
		person.setPrice(3499.09);
		person.setEncounter(encounter);
		
		Person person1 = new Person();
		person1.setName("Prasanth");
		person1.setNo(639394342);
		person1.setPrice(899.009);
		person1.setEncounter(encounter);
		
		Person person2 = new Person();
		person2.setName("Rajeesh");
		person2.setNo(729402042);
		person2.setPrice(4999.00);
		person2.setEncounter(encounter);
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(person);
		persons.add(person1);
		persons.add(person2);
		
		encounter.setPerson(persons);
		
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityManager.persist(person);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityTransaction.commit();

	}
}