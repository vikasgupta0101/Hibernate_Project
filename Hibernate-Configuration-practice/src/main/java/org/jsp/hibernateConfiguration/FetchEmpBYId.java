package org.jsp.hibernateConfiguration;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class FetchEmpBYId {
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enetr tha id to get details");
	int id =sc.nextInt();
	Configuration cfg= new Configuration().configure();
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	Employee emp  =session.get(Employee.class,id);
	if(emp !=null) {
		System.out.println("user found");
		System.out.println(emp);
	}else {
		System.out.println("invalid id");
	}
	
}

}
