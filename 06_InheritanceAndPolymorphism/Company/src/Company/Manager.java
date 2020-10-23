package Company;

public class Manager implements Employee {

  private final int MIN_AMOUNT_EARNED_MONEY = 115000;
  private final int MAX_AMOUNT_EARNED_MONEY = 140000;
  private final int AMOUNT_EARNED_MONEY =
      (int) (Math.random() * (MAX_AMOUNT_EARNED_MONEY - MIN_AMOUNT_EARNED_MONEY))
          + MIN_AMOUNT_EARNED_MONEY;
  private final int FIX_PERCENT_BONUS = 5;
  private final int FIX_AMOUNT_SALARY = 100000;
  private int monthSalary;



  public Manager() {
    this.monthSalary = FIX_AMOUNT_SALARY + ((AMOUNT_EARNED_MONEY / 100) * FIX_PERCENT_BONUS);
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
