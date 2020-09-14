package ClientsBank;

public class IndividualEntrepreneur extends Client {

  public IndividualEntrepreneur(double money) {
    super.money = money;
  }

  @Override
  public void accountInformation() {
    System.out.println("Баланс счёта: " + accountBalance()
        + "\nУсловия пополнения счёта: " + "Пополнение с комиссией "
        + getDepositComission(100) + " %, если сумма меньше 1000 рублей. И с комиссией "
        + getDepositComission(50) + "%, если сумма больше либо равна 1000 рублей"
        + "\nУсловия списания со счёта: " + "Снятие без комиссии");
  }

  @Override
  protected double getWithdrawalComission(double amount) {
    return 0;
  }

  @Override
  protected double getDepositComission(double amount) {
   final double PERCENT_COMMISSION_BEFORE_1000 = 1;
   final double PERCENT_COMMISSION_AFTER_1000 = 0.5;
    if (amount < 1000) {
      return amount / 100 * PERCENT_COMMISSION_BEFORE_1000;
    } 
      return amount / 100 * PERCENT_COMMISSION_AFTER_1000;
    }
}
