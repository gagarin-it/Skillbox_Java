package Accounts;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositeAccount extends BankAccount {

  Calendar dateNow, dateNextRemovalMoney;

  public DepositeAccount(double money) {
    super(money);
  }

  @Override
  public void addMoney(double addMoney) {
    this.money = money + addMoney;
    dateNextRemovalMoney = new GregorianCalendar();
    dateNextRemovalMoney.add(Calendar.MONTH, -1);
  }

  @Override
  public void removalMoney(double removalMoney) {
    dateNow = new GregorianCalendar();
    if (dateNow.after(dateNextRemovalMoney)) {
      if (this.money - removalMoney >= 0) {
        this.money = money - removalMoney;
      } else {
        System.out.println("На счёте не достаточно средств для снятия");
      }
    } else {
      System.out.println("Нельзя снимать деньги в течение месяца после последнего внесения");
    }
  }
}