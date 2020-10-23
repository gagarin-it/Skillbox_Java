package Company;

public class TopManager implements Employee {

  private final int FIX_PERCENT_BONUS = 150;
  private final int FIX_AMOUNT_SALARY = 150000 + (int) (Math.random() * 10000);
  private int monthSalary;
  private Company company;

  public TopManager(Company company) {
    this.company = company;
    this.monthSalary = FIX_AMOUNT_SALARY + getBonusSalary();

  }

  @Override
  public Integer getMonthSalary() {
    return monthSalary;
  }

  @Override
  public String toString() {
    return getMonthSalary() + " руб.";
  }

  private int getBonusSalary() {
    int bonusSalary = 0;
    if (company.getIncome() > 10000000) {
      bonusSalary = (FIX_AMOUNT_SALARY / 100) * FIX_PERCENT_BONUS;
    }
    return bonusSalary;
  }

}
