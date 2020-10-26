import Company.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Company company = new Company("Яндекс");
    System.out.println("Доход \"" + company.getNameCompany() + "\": " + company.getIncome());
    Company company2 = new Company("Google");
    System.out.println("Доход \"" + company2.getNameCompany() + "\": " + company2.getIncome());

    List<Employee> operator1 = new ArrayList<>();
    for(int i = 0; i < 180; i++){
      operator1.add(new Operator());
    }
    company.hireAll(operator1);

    List<Employee> manager1 = new ArrayList<>();
    for(int i = 0; i < 80; i++){
      manager1.add(new Manager());
    }
    company.hireAll(manager1);

    List<Employee> topmanager1 = new ArrayList<>();
    for(int i = 0; i < 10; i++){
      topmanager1.add(new TopManager(company));
    }
    company.hireAll(topmanager1);

    List<Employee> operator2 = new ArrayList<>();
    for(int i = 0; i < 280; i++){
      operator2.add(new Operator());
    }
    company2.hireAll(operator2);

    List<Employee> manager2 = new ArrayList<>();
    for(int i = 0; i < 150; i++){
      manager2.add(new Manager());
    }
    company2.hireAll(manager2);

    List<Employee> topmanager2 = new ArrayList<>();
    for(int i = 0; i < 15; i++){
      topmanager2.add(new TopManager(company2));
    }
    company2.hireAll(topmanager2);

    company2.fire();

    System.out.println("Список зарплат TOP " + company.getNameCompany() + ":");
    System.out.println(company.getTopSalaryStaff(13));
    System.out.println("Список зарплат TOP " + company2.getNameCompany() + ":");
    System.out.println(company2.getTopSalaryStaff(-1));
    System.out.println("Список зарплат LOW " + company.getNameCompany() + ":");
    System.out.println(company.getLowestSalaryStaff(30));
    System.out.println("Список зарплат LOW " + company2.getNameCompany() + ":");
    System.out.println(company2.getLowestSalaryStaff(0));
    company.fire();
    company2.fire();
    System.out.println("Список зарплат TOP " + company.getNameCompany() + ":");
    System.out.println(company.getTopSalaryStaff(13));
    System.out.println("Список зарплат TOP " + company2.getNameCompany() + ":");
    System.out.println(company2.getTopSalaryStaff(10));
    System.out.println("Список зарплат LOW " + company.getNameCompany() + ":");
    System.out.println(company.getLowestSalaryStaff(30));
    System.out.println("Список зарплат LOW " + company2.getNameCompany() + ":");
    System.out.println(company2.getLowestSalaryStaff(30));
  }
}
