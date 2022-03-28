package one_to_many_bi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import one_to_many_bi.dto.Branch;
import one_to_many_bi.dto.Hospital;

public class TestHospital {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital = new Hospital();
		hospital.setName("manipal");
		hospital.setFounder("vaibhav");
		
		Branch branch1 = new Branch();
		branch1.setEmail("Mani@gmail.com");
		branch1.setName("rajajinager");
		branch1.setPhone("9973453453");
		branch1.setHospital(hospital);
		
		Branch branch2 = new Branch();
		branch2.setEmail("Mani234@gmail.com");
		branch2.setName("Gavipur");
		branch2.setPhone("9973453453");
		branch2.setHospital(hospital);
		
		Branch branch3 = new Branch();
		branch3.setEmail("Mani74@gmail.com");
		branch3.setName("BTM");
		branch3.setPhone("9973453453");
		branch3.setHospital(hospital);
		
		Branch branch4 = new Branch();
		branch4.setEmail("Mani0987@gmail.com");
		branch4.setName("Mejastic");
		branch4.setPhone("9973453453");
		branch4.setHospital(hospital);
		
		List<Branch> branchs = new ArrayList<Branch>();
		branchs.add(branch1);
		branchs.add(branch2);
		branchs.add(branch3);
		branchs.add(branch4);
		
		hospital.setBranch(branchs);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityManager.persist(branch4);
		entityTransaction.commit();
		

	}

}
