package deuxshiri.io.virgool.demo.controller;

import deuxshiri.io.virgool.demo.entity.Employee;
import deuxshiri.io.virgool.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  private EmployeeService service;

  @Autowired
  public EmployeeController(EmployeeService service) {
    this.service = service;
  }

  @GetMapping("/list")
  public String listEmployees(Model model) {
    // get employees from db
    List<Employee> theEmployees = service.findAll();

    // add to the spring model
    model.addAttribute("employees", theEmployees);

    return "employees/list-employees";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {
    model.addAttribute("employee", new Employee());
    return "employees/employee-form";
  }

  @PostMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("id") int id, Model model) {
    model.addAttribute("employee", service.findById(id));
    return "employees/employee-form";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    service.save(employee);
    return "redirect:/employees/list";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam("id") int id) {
    service.deleteById(id);
    return "redirect:/employees/list";
  }
}
