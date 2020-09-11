package Accounts;

public class BankAccount {

  protected double money;
  private BankAccount receiver;

  public BankAccount(double money) {
    this.money = money;
  }

  public double accountBalance() {
    return money;
  }

  public void addMoney(double addMoney) {
    this.money = money + addMoney;
  }

  public void removalMoney(double removalMoney) {
    if (this.money - removalMoney >= 0) {
      this.money = money - removalMoney;
    } else {
      System.out.println("На счёте не достаточно средств для снятия");
    }
  }

  public boolean send(BankAccount receiver, double amount) {
    boolean transferConfirm = this.money - amount >= 0;
    removalMoney(amount);
    if (transferConfirm) {
      receiver.addMoney(amount);
    }
    System.out.println(transferConfirm);
    return transferConfirm;
  }
}