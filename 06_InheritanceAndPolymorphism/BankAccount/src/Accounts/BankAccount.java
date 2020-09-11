package Accounts;

public class BankAccount {

  double money;

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
    this.money = money - removalMoney;
  }
}