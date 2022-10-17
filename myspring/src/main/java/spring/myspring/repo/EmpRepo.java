package spring.myspring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.myspring.model.Employee;

public interface EmpRepo extends JpaRepository<Employee, Long> {

}
