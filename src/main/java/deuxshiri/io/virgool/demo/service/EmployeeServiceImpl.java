package deuxshiri.io.virgool.demo.service;

import deuxshiri.io.virgool.demo.dao.EmployeeRepository;
import deuxshiri.io.virgool.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository repository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Employee> findAll() {
    return repository.findAllByOrderByLastNameAsc();
  }

  @Override
  public Employee findById(int id) {
    Optional<Employee> result = repository.findById(id);
    Employee theEmployee;
    if (result.isPresent()) {
      theEmployee = result.get();
    } else {
      // we didn't find the employee
      throw new RuntimeException("Did not find employee id - " + id);
    }
    return theEmployee;
  }

  @Override
  public void save(Employee theEmployee) {
    repository.save(theEmployee);
  }

  @Override
  public void deleteById(int id) {
    repository.deleteById(id);
  }
}
