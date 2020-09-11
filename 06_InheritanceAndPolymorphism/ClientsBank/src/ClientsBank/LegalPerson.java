package ClientsBank;

public class LegalPerson extends Client {

  private static final double PERCENT_COMMISSION = 1;

  public LegalPerson(double money) {
    super.money = money;
  }

  @Override
  public void accountInformation() {
    System.out.println("Баланс счёта: " + accountBalance()
        + "\nУсловия пополнения счёта: " + "Пополнение без комиссии"
        + "\nУсловия списания со счёта: " + "Снятие с комиссией " + PERCENT_COMMISSION + " %");
  }

  @Override
  public void removalMoney(double removalMoney) {
    double commissionForRemoval = removalMoney / 100 * PERCENT_COMMISSION;
    boolean notNegativeBalance = removalMoney + commissionForRemoval <= money;
    if (notNegativeBalance) {
      this.money = money - removalMoney - commissionForRemoval;
      System.out.println("Списано " + removalMoney + " , с комиссией " + commissionForRemoval);
    } else {
      System.out.println("Сумма снятия с комиссией превышает остаток на счёте");
    }
  }
}
