import Company.*;

public class Main {

  public static void main(String[] args) {
    Company company = new Company("Яндекс");
    System.out.println("Доход \"" + company.getNameCompany() + "\": " + company.getIncome());
    Company company2 = new Company("Google");
    System.out.println("Доход \"" + company2.getNameCompany() + "\": " + company2.getIncome());
    company.hireAll(new Operator(),180);
    company.hireAll(new Manager(),80);
    company.hireAll(new TopManager(company),10);
    company2.hireAll(new Operator(),80);
    company2.hireAll(new Manager(),50);
    company2.hireAll(new TopManager(company),5);
    company.fire();
    company2.hireAll(new Operator(),80);
    company2.hireAll(new Manager(),50);
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
