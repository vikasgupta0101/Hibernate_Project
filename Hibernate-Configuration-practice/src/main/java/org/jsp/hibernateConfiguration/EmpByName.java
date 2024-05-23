package org.jsp.hibernateConfiguration;



import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmpByName {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter name to find detail");
		String name= sc.next();
		
		String hql= "select e from Employee e where e.name=?1";
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> query = session.createQuery(hql);
		
		query.setParameter(1, name);
		List<Employee> emps = query.getResultList();
		
		if(emps.isEmpty()) {
			System.err.println("NO user present");
		}
		else {
			for(Employee emp:emps) {
				System.out.println(emp);
			}
		}
	}

}
