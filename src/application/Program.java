package application;

import java.sql.Connection;
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
		
		System.out.println("\n=== TEST 2 seller FindById  ===");
		Department dep = new Department(2,null);
		List<Seller> list = DaoFactory.createSellerDao(conn).findByDepartment(dep);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 2 seller FindById  ===");
		list = DaoFactory.createSellerDao(conn).findAll();
		list.forEach(System.out::println);
		
		DB.closeConnection();
	}
}
