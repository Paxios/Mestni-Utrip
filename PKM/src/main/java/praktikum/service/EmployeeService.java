package praktikum.service;

import java.util.List;

import praktikum.model.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	void getEmployeeById(String empid);
}