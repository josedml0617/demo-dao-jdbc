package application;

import java.sql.Connection;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		SellerDao seller = DaoFactory.createSellerDao(conn);
		System.out.println(seller.findById(3));
	}
}
