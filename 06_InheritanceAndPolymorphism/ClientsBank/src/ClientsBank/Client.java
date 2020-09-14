package ClientsBank;

public abstract class Client {

  protected double money;

  public double accountBalance() {
    return money;
  }

  public abstract void accountInformation();
  protected abstract double getWithdrawalComission(double amount);
  protected abstract double getDepositComission(double amount);

  public void depositMoney(double addMoney) {
    this.money = money + addMoney - getDepositComission(addMoney);
    System.out.println("Внесено " + (addMoney - getDepositComission(addMoney)));
  }

  public void withdrawalMoney(double removalMoney) {
    boolean notNegativeBalance = removalMoney + getWithdrawalComission(removalMoney) <= money;
    if (notNegativeBalance) {
      this.money = money - removalMoney - getWithdrawalComission(removalMoney);
      System.out.println("Списано " + (removalMoney + getWithdrawalComission(removalMoney)));
    } else {
      System.out.println("Сумма снятия с комиссией превышает остаток на счёте");
    }
  }
}
