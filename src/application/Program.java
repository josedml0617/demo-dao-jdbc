package application;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = DB.getConnection();
		Seller seller = DaoFactory.createSellerDao(conn).findById(3);
		System.out.println("=== TEST 1 seller FindById  ===");
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2 seller FindByDepartment  ===");
		Department dep = new Department(2,null);
		List<Seller> list = DaoFactory.createSellerDao(conn).findByDepartment(dep);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3 seller FindAll  ===");
		list = DaoFactory.createSellerDao(conn).findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4 insert seller  ===");
		Seller newSeller = new Seller(null, "José", "Jose@gmail.com", new Date(), 4600.00, dep);
		DaoFactory.createSellerDao(conn).insert(newSeller);
		System.out.println("Inserted! New id = "+newSeller.getId());
		
		System.out.println("\n=== TEST 5 update seller  ===");
		seller = DaoFactory.createSellerDao(conn).findById(7);
		seller.setName("Victória");
		DaoFactory.createSellerDao(conn).update(seller);
		System.out.println("Update executed: "+DaoFactory.createSellerDao(conn).findById(7));
		
		System.out.println("\n=== TEST 6 delete seller  ===");
		System.out.print("Enter id for delete test: ");
		DaoFactory.createSellerDao(conn).deleteById(sc.nextInt());
		System.out.println("Delete complete!");
	
		DB.closeConnection();
		sc.close();
		
	}
}
