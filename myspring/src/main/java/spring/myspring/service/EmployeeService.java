package spring.myspring.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.myspring.model.Employee;
import spring.myspring.repo.EmpRepo;



@Service
public class EmployeeService {
	@Autowired
	EmpRepo repo;
	public List<Employee>display()
	{
		return repo.findAll();
	}
	public void saveEmployee(Employee employee)
	{
		repo.save(employee);
	}
	public Employee getEmp(long id)
	{
		return repo.findById(id).get();
	}
	public void delete(long id)
	{
		repo.deleteById(id);
	}
	
	
}
