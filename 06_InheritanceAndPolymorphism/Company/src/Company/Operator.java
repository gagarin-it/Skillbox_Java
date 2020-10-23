package Company;

public class Operator implements Employee {

  private final int FIX_AMOUNT_SALARY = 60000 + (int) (Math.random() * 10000);
  private int monthSalary;

  public Operator() {
    this.monthSalary = FIX_AMOUNT_SALARY;
  }

  @Override
  public Integer getMonthSalary() {
    return monthSalary;
  }

  @Override
  public String toString() {
    return getMonthSalary() + " руб.";
  }

}
