package applicaton;

import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		DepartmentDao departmentDao=DaoFactory.createDepartmentDao();
		
		
		System.out.println("=== TEST 1: department findById===");
		Department department=departmentDao.findById(2);
		System.out.println(department);

		
		System.out.println("=== TEST 2: department findAll===");
		List<Department> list=departmentDao.findAll(); 
		
		for(Department obj: list) {
			System.out.println(obj);
		}
		
		
		System.out.println("=== TEST 3: seller Insert===");
		Department newDepartment=new Department(null, "jewelry");
		departmentDao.insert(newDepartment);
		System.out.println(newDepartment);
		
	
		System.out.println("=== TEST 4: department upDate===");
		department=departmentDao.findById(7);
		department.setName("AnimeItens");
		departmentDao.update(department);
		System.out.println("UpdatedCompleted!");	
		
		System.out.println("=== TEST 5: department delete===");
		System.out.print("Enter id for delete test: ");
		int id =sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}
