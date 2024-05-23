package org.jsp.hibernateConfiguration;



import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EnpByIdandName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the aadharNo And Phone ");
		long phone = sc.nextLong();
		long aadharNo = sc.nextLong();
		
		String hql= "select e from  Employee e where e.aadharNo =?1 and e.phone=:ph";
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> query = session.createQuery(hql);
		query.setParameter(1, aadharNo);
		query.setParameter("ph", phone);
		
		try {
			Employee emp = query.getSingleResult();
			System.out.println(emp);
		}catch(NoResultException e) {
			System.out.println("Invalid aadharNo and phone");
		}
	}

}
