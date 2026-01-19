package application;

import java.sql.Connection;
import java.util.Locale;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.services.MenuService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = DB.getConnection();
		
		SellerDao sellerDao = DaoFactory.createSellerDao(conn);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao(conn);
		
		MenuService menuService = new MenuService(sellerDao, departmentDao, sc);
		menuService.start();
		
		DB.closeConnection();
		
		sc.close();

	}
}
