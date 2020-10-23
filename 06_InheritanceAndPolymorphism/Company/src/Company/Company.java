package Company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

  private String nameCompany;
  private int income;
  List<Employee> employees;

  public Company(String nameCompany) {
    this.employees = new ArrayList<>();
    this.nameCompany = nameCompany;
    this.income = (int) ((Math.random() * 30000) * (Math.random() * 1000));
  }

  public void hire(Employee employee) {
    employees.add(employee);
  }

  public void hireAll(Employee employee, int countEmployee) {
    for (int i = 0; i < countEmployee; i++) {
      if (employee.getClass().getName().equals("Company.Manager")) {
        hire(new Manager());
      } else if (employee.getClass().getName().equals("Company.Operator")) {
        hire(new Operator());
      } else {
        hire(new TopManager(Company.this));
      }
    }
  }

  public void fire() {
    for (int i = employees.size() - 1; i >= 0; i--) {
      if (i % 2 == 0) {
        employees.remove(i);
      }
    }
  }

  public String getNameCompany() {
    return nameCompany;
  }

  public void setNameCompany(String nameCompany) {
    this.nameCompany = nameCompany;
  }

  public int getIncome() {
    return income;
  }

  public List<Employee> getTopSalaryStaff(int count) {
    if (count < 0 || count > employees.size()) {
      return Collections.emptyList();
    } else {
      Collections.sort(employees, ((o1, o2) -> o2.getMonthSalary().compareTo(o1.getMonthSalary())));
      List<Employee> temp = new ArrayList<>();
      for(int i = 0; i < count; i++){
        temp.add(employees.get(i));
      }
      return temp;
    }
  }
  public List<Employee> getLowestSalaryStaff(int count) {
    if (count < 0 || count > employees.size()) {
      return Collections.emptyList();
    } else {
      Collections.sort(employees, ((o1, o2) -> o1.getMonthSalary().compareTo(o2.getMonthSalary())));
      List<Employee> temp = new ArrayList<>();
      for(int i = 0; i < count; i++){
        temp.add(employees.get(i));
      }
      return temp;
    }
  }
}

