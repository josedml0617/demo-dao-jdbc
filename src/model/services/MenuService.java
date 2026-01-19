package model.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import model.util.DateFormatter;

public class MenuService {
	
	private SellerDao sellerDao;
	private DepartmentDao departmentDao;
	private Scanner sc;
	
	public MenuService(SellerDao sellerDao ,DepartmentDao departmentDao, Scanner sc) {
		this.sellerDao = sellerDao;
		this.departmentDao = departmentDao;
		this.sc = sc;
	}
	
	private int option;
	
		public void start() {
			do {
			    System.out.println("\n=== MENU PRINCIPAL ===");
			    System.out.println("1 - Inserir vendedor");
			    System.out.println("2 - Atualizar vendedor");
			    System.out.println("3 - Deletar vendedor por ID");
			    System.out.println("4 - Buscar vendedor por ID");
			    System.out.println("5 - Buscar vendedores por departamento");
			    System.out.println("6 - Buscar todos vendedores");
			    System.out.println("7 - Inserir departamento");
			    System.out.println("8 - Atualizar departamento");
			    System.out.println("9 - Deletar departamento por ID");
			    System.out.println("10 - Buscar todos departamentos");
			    System.out.println("11 - Buscar departamento por ID");
			    System.out.println("0 - Sair");
			    System.out.print("\nOpção escolhida: ");

			    option = sc.nextInt();
			    sc.nextLine(); 

			    switch (option) {
			        case 1: insertSeller(sc); break;
			        case 2: updateSeller(); break;
			        case 3: deleteSeller(); break;
			        case 4: findSellerById(); break;
			        case 5: findSellerByDepartment(); break;
			        case 6: findAllSellers(); break;
			        case 7: insertDepartment(); break;
			        case 8: updateDepartment(); break;
			        case 9: deleteDepartment(); break;
			        case 10: findAllDepartment(); break;
			        case 11: findDepartmentById(); break;
			        case 0: System.out.println("Encerrando..."); break;
			        default: System.out.println("Opção inválida!");
			    }
			} while (option != 0);
		}
		
		private void insertSeller(Scanner sc){
			   System.out.println("\n=== Inserir vendedor ===");
			   System.out.println("Preencha os dados do novo vendedor. ");
			   System.out.print("Name: ");
			   String name = sc.nextLine();
			   System.out.print("Email: ");
			   String email = sc.nextLine();
			   System.out.print("Data de nascimento: ");
			   LocalDate birthDate = LocalDate.parse(sc.nextLine(), DateFormatter.FMT);
			   System.out.print("Salário base: ");
			   Double baseSalary = sc.nextDouble();
			   System.out.print("Departamento ID: ");
			   int departmentId = sc.nextInt();
			   sc.nextLine();
			   Seller seller = new Seller(null, name, email, birthDate, baseSalary, new Department(departmentId, null));
			   sellerDao.insert(seller);
			   System.out.println("Vendedor inserido com sucesso!");
		}
		
		private void updateSeller() {
			System.out.println("\n=== Atualizar o vendedor ===");
			System.out.println("Preencha os novos dados para atualizar o vendedor. ");
				System.out.print("ID do vendedor: ");
				int id = sc.nextInt();
				sc.nextLine();
			   System.out.print("Name: ");
			   String name = sc.nextLine();
			   System.out.print("Email: ");
			   String email = sc.nextLine();
			   System.out.print("Data de nascimento (dd/mm/yyyy): ");
			   LocalDate birthDate = LocalDate.parse(sc.nextLine(), DateFormatter.FMT);
			   System.out.print("Salário base: ");
			   Double baseSalary = sc.nextDouble();
			   System.out.print("Departamento ID: ");
			   int departmentId = sc.nextInt();
			   sc.nextLine();
			   Seller seller = new Seller(id, name, email, birthDate, baseSalary, new Department(departmentId, null));
			   sellerDao.update(seller);
			   System.out.println("Vendedor atualizado com sucesso!");
		}
		
		private void deleteSeller() {
			System.out.println("\n=== Deletar vendedor por ID ===");
			System.out.print("Digite o ID do vendedor que você deseja apagar: ");
				int id = sc.nextInt();
				sc.nextLine();
				sellerDao.deleteById(id);
				System.out.println("Vendedor deletado com sucesso!");
		}
		
		private void findSellerById() {
			System.out.println("\n=== Buscar vendedor por ID ===");
			System.out.print("Digite o ID do vendedor que você deseja encontrar: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Vendedor encontrado: ");
				System.out.println(sellerDao.findById(id));
		}
		
		private void findSellerByDepartment() {
			System.out.println("\n=== Buscar vendedores por departamento ===");
			System.out.print("Digite o ID do departamento dos vendedores que você deseja encontrar: ");
				int id = sc.nextInt();
				sc.nextLine();
				List<Seller> seller = sellerDao.findByDepartment(new Department(id, null));
				System.out.println("Vendedores do departamento encontrados: ");
				seller.forEach(System.out::println);
		}
		
		private void findAllSellers() {
			System.out.println("\n=== Buscar todos vendedores ===");
			List<Seller> seller = sellerDao.findAll();
			System.out.println("Vendedores encontrados: ");
			seller.forEach(System.out::println);
		}
		
		private void insertDepartment() {
			System.out.println("\n=== Inserir departamento ===");
			System.out.print("Digite o nome do novo departamento: ");
			String name = sc.nextLine();
			departmentDao.insert(new Department(null, name));
			System.out.println("Departamento inserido com sucesso!");
		}
		
		private void updateDepartment() {
			System.out.println("\n=== Atualizar departamento ===");
			System.out.print("Digite o ID do departamento que você deseja atualizar: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Digite o nome do novo departamento: ");
			String name = sc.nextLine();
			departmentDao.update(new Department(id, name));
			System.out.println("Departamento atualizado com sucesso!");
		}
		
		private void deleteDepartment() {
			System.out.println("\n=== Deletar departamento por ID ===");
			System.out.print("Digite o ID do departamento que você deseja deletar: ");
			int id = sc.nextInt();
			sc.nextLine();
			departmentDao.deleteById(id);
			System.out.println("Departamento deletado com sucesso!");
		}
		
		private void findAllDepartment() {
			System.out.println("\n=== Buscar todos departamentos ===");
			System.out.println("Buscando departamentos...");
			List<Department> department = departmentDao.findAll();
			System.out.println("Departamentos econtrados:");
			department.forEach(System.out::println);
		}
		
		private void findDepartmentById() {
			System.out.println("\n=== Buscar departamento por ID ===");
			System.out.print("Digite o ID do departamento que você deseja encontrar: ");
			int id = sc.nextInt();
			sc.nextLine();
			Department department = departmentDao.findById(id);
			System.out.println("Departamento encontrado: ");
			System.out.println(department);
		}
		
}
