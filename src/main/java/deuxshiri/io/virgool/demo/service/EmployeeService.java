package deuxshiri.io.virgool.demo.service;

import deuxshiri.io.virgool.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> findAll();

  Employee findById(int id);

  void save(Employee employee);

  void deleteById(int id);
}
