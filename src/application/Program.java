package application;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();
		SellerDao seller = DaoFactory.createSellerDao(conn);
		System.out.println("=== TEST 1 seller FindById  ===");
		System.out.println(seller.findById(3));
		
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
		DB.closeConnection();
	}
}
