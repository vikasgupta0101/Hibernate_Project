package org.jsp.hibernateConfiguration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmp {
	
	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setId(3);
		emp.setName("kavi");
		emp.setAadharNo(906787890L);
		emp.setPhone(97456L);
		emp.setSalary(988678);
		
		Configuration cfg=new Configuration().configure();
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session = factory.openSession();
		int id= (Integer) session.save(emp);
		Transaction t=session.beginTransaction();
		t.commit();
		System.out.println("emp saved with id:"+ id);
		
	}

}
