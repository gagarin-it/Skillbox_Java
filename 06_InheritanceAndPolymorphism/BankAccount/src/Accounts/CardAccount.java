package Accounts;

public class CardAccount extends BankAccount {

  private static final double PERCENT_COMMISSION = 1;

  public CardAccount(double money) {
    super(money);
  }

  @Override
  public void removalMoney(double removalMoney) {
    double commissionForRemoval = removalMoney / 100 * PERCENT_COMMISSION;
    boolean notNegativeBalance = removalMoney + commissionForRemoval <= money;
    if (notNegativeBalance) {
      this.money = money - removalMoney - commissionForRemoval;
    } else {
      System.out.println("Сумма снятия с комиссией превышает остаток на счёте");
    }
  }

  @Override
  public boolean send(BankAccount receiver, double amount) {
    boolean transferConfirm = this.money - amount - (amount / 100 * PERCENT_COMMISSION) >= 0;
    removalMoney(amount);
    if (transferConfirm) {
      receiver.addMoney(amount);
    }
    System.out.println(transferConfirm);
    return transferConfirm;
  }
}