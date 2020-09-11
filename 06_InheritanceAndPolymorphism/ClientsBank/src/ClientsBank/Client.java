package ClientsBank;

public abstract class Client {

  protected double money;

  public double accountBalance() {
    return money;
  }

  public abstract void accountInformation();

  public void addMoney(double addMoney) {
    this.money = money + addMoney;
  }

  public void removalMoney(double removalMoney) {
    if (this.money - removalMoney >= 0) {
      this.money = money - removalMoney;
      System.out.println("Списано " + removalMoney);
    } else {
      System.out.println("На счёте не достаточно средств для снятия");
    }
  }
}
