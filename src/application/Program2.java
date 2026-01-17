package application;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = DB.getConnection();
		
		System.out.println("=== TEST 1 department FindById  ===");
		Department dep = DaoFactory.createDepartmentDao(conn).findById(2);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2 department FindAll  ===");
		List<Department> list = DaoFactory.createDepartmentDao(conn).findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3 insert department  ===");
		Department newDepartment = new Department(null,"Pharmacy");
		DaoFactory.createDepartmentDao(conn).insert(newDepartment);
		System.out.println("Department insert! New ID = "+newDepartment.getId());
		
		System.out.println("\n=== TEST 4 update department  ===");
		dep = DaoFactory.createDepartmentDao(conn).findById(6);
		dep.setName("Software");
		DaoFactory.createDepartmentDao(conn).update(dep);
		System.out.println("Update executed: "+DaoFactory.createDepartmentDao(conn).findById(6));
		
		System.out.println("\n=== TEST 5 delete seller  ===");
		System.out.print("Enter id for delete test: ");
		DaoFactory.createDepartmentDao(conn).deleteById(sc.nextInt());
		System.out.println("Delete complete!");
		
		DB.closeConnection();
		
		sc.close();
	}

}
