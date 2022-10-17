package spring.myspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.myspring.model.Employee;
import spring.myspring.service.EmployeeService;

@Controller
public class EmpController {
	@Autowired
	EmployeeService service;
	@RequestMapping("/")
	public String showpage(Model model)
	{
		System.out.println("====Record is Here====");
		List<Employee> list=service.display();
		for(Employee emp:list)
		{
			System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getSalary());
			
		}
		model.addAttribute("abc",list);
		return "show";
		
			}
	@RequestMapping("/addData")
	public String newData(Model model)
	{
	Employee employee=new Employee();
				model.addAttribute("employee",employee);
				return "add_pro";
	}
	@RequestMapping(value= "/save" , method = RequestMethod.POST)
	public String saveData(@ModelAttribute("employee")Employee employee)
	{
		service.saveEmployee(employee);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView editData(@PathVariable(name = "id") int id)
	{
		ModelAndView view = new ModelAndView("edit_pro");
		Employee employee = service.getEmp(id);
		view.addObject("employee", employee);
		return view;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable(name = "id") int id)
	{
		service.delete(id);
		return "redirect:/";
	}
	
	}
