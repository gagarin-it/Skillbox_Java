package ClientsBank;

public class IndividualEntrepreneur extends Client {

  private static final double PERCENT_COMMISSION_BEFORE_1000 = 1;
  private static final double PERCENT_COMMISSION_AFTER_1000 = 0.5;

  public IndividualEntrepreneur(double money) {
    super.money = money;
  }

  @Override
  public void accountInformation() {
    System.out.println("Баланс счёта: " + accountBalance()
        + "\nУсловия пополнения счёта: " + "Пополнение с комиссией "
        + PERCENT_COMMISSION_BEFORE_1000 + " %, если сумма меньше 1000 рублей. И с комиссией "
        + PERCENT_COMMISSION_AFTER_1000 + "%, если сумма больше либо равна 1000 рублей"
        + "\nУсловия списания со счёта: " + "Снятие без комиссии");
  }

  @Override
  public void addMoney(double addMoney) {
    double commissionForAddBefore1000 = addMoney / 100 * PERCENT_COMMISSION_BEFORE_1000;
    double commissionForAddAfter1000 = addMoney / 100 * PERCENT_COMMISSION_AFTER_1000;
    if (addMoney < 1000) {
      this.money = money + addMoney - commissionForAddBefore1000;
    } else {
      this.money = money + addMoney - commissionForAddAfter1000;
    }
  }
}
