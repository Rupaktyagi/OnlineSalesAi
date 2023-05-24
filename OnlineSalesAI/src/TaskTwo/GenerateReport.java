package TaskTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenerateReport {

	private  List<Department> getTopDepartments(List<Department> departments, List<Salary> salaries,
			List<Employee> employees, int limit) {
		List<Department> result = new ArrayList<>();

		for (Department department : departments) {
			int employeeCount = 0;
			double totalSalary = 0;

			for (Employee employee : employees) {
				if (employee.getDepartmentId() == department.getId()) {
					employeeCount++;

					for (Salary salary : salaries) {
						if (salary.getEmployeeId() == employee.getId()) {
							totalSalary =  totalSalary+salary.getAmount();
							break;
						}
					}
				}
			}

			if (employeeCount > 0) {
				double averageSalary = totalSalary / employeeCount;
				department.setAverageSalary(averageSalary);
				result.add(department);
			}
		}

		result.sort(Comparator.comparingDouble(Department::getAverageSalary).reversed());
		if (result.size() > limit) {
			result = result.subList(0, limit);
		}

		return result;
	}

	private  List<Department> readDepartments(String filePath) {
		List<Department> departments = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				departments.add(new Department(id, name));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return departments;
	}

	private  List<Salary> readSalaries(String filePath) {
		
		List<Salary> salaries = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				int employeeId = Integer.parseInt(data[0]);
				int month = Integer.parseInt(data[1]);
				double amount = Double.parseDouble(data[2]);
				salaries.add(new Salary(employeeId, month, amount));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return salaries;
	}

	private  List<Employee> readEmployees(String filePath) {
		
		
		List<Employee> employees = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				int departmentId = Integer.parseInt(data[2]);
				employees.add(new Employee(id, name, departmentId));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return employees;
	}

	public static void main(String[] args) {
		
		GenerateReport object=new GenerateReport();
		
		
		List<Department> departments = object.readDepartments("departments.csv");
		
		List<Salary> salaries = object.readSalaries("salaries.csv");
		
		List<Employee> employees = object.readEmployees("employees.csv");
		
		List<Department> topDepartments = object.getTopDepartments(departments, salaries, employees, 3);

		System.out.println("DEPT_NAME");
		System.out.println("AVG_MONTHLY_SALARY (USD)");
		System.out.println("-------------------------");

		for (Department department : topDepartments) {
			System.out.println(department.getName());
			System.out.println(department.getAverageSalary());
			System.out.println();
		}
	}

}
