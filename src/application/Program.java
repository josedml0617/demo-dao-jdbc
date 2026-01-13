package application;

import java.time.LocalDate;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department dp = new Department(1,"Pharmacy");
		Seller sll = new Seller(1, "Vic", "Vic@gmail.com", LocalDate.now(), 2500.00, dp);
		System.out.println(sll);
		
	}
}
