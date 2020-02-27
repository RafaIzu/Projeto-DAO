package applicaton;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
			
		SellerDao sellerDao=DaoFactory.createSellerDao();
		System.out.println("=== TEST 2: seller findByDepartment===");
		Seller seller=sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findByDepartment===");
		Department department=new Department(2,null);
		List<Seller> list=sellerDao.findByDepartment(department);
		
		
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: seller findAll===");
		list=sellerDao.findAll();
		
		for(Seller obj: list) {
			System.out.println(obj);
		}
			
		System.out.println("=== TEST 4: seller findAll===");
		Seller newSeller=new Seller(null, "Marisa", "Kirisame@gmail.com" , new Date(), 5000.00, department);
		sellerDao.insert(newSeller);
		System.out.println(newSeller);
		
		System.out.println("=== TEST 5: seller upDate===");
		seller=sellerDao.findById(1);
		seller.setName("Marth Waine");
		sellerDao.update(seller);
		System.out.println("UpdatedCompleted!");	
		
		System.out.println("=== TEST 6: seller delete===");
		System.out.print("Enter id for delete test: ");
		int id =sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();

	}

}
