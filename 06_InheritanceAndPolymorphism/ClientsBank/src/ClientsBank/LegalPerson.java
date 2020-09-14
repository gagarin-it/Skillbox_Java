package ClientsBank;

public class LegalPerson extends Client {


  public LegalPerson(double money) {
    super.money = money;
  }

  @Override
  public void accountInformation() {
    System.out.println("Баланс счёта: " + accountBalance()
        + "\nУсловия пополнения счёта: " + "Пополнение без комиссии"
        + "\nУсловия списания со счёта: " + "Снятие с комиссией: " + getWithdrawalComission(100) + " %");
  }

  @Override
  protected double getWithdrawalComission(double amount) {
      final double PERCENT_COMMISSION = 1;
      return amount / 100 * PERCENT_COMMISSION;
    }

  @Override
  protected double getDepositComission(double amount) {
    return 0;
  }

  @Override
  public void withdrawalMoney(double removalMoney) {
    boolean notNegativeBalance = removalMoney + getWithdrawalComission(removalMoney) <= money;
    if (notNegativeBalance) {
      this.money = money - removalMoney - getWithdrawalComission(removalMoney);
      System.out.println("Списано " + removalMoney + " , с комиссией " + getWithdrawalComission(removalMoney));
    } else {
      System.out.println("Сумма снятия с комиссией превышает остаток на счёте");
    }
  }
}
