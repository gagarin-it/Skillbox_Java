package Accounts;

public class CardAccount extends BankAccount {

  static final double PERCENT_COMMISSION = 1;

  public CardAccount(double money) {
    super(money);
  }

  public void removalMoney(double removalMoney) {
    double commissionForRemoval = removalMoney / 100 * PERCENT_COMMISSION;
    boolean notNegativeBalance = removalMoney + commissionForRemoval <= money;
    if (notNegativeBalance) {
      this.money = money - removalMoney - commissionForRemoval;
    } else {
      System.out.println("Сумма снятия с комиссией превышает остаток на счёте");
    }
  }
}