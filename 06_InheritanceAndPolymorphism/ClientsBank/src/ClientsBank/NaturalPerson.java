package ClientsBank;

public class NaturalPerson extends Client {

  public NaturalPerson(double money) {
    super.money = money;
  }

  @Override
  public void accountInformation() {
    System.out.println("Баланс счёта: " + accountBalance()
        + "\nУсловия пополнения счёта: " + "Пополнение без комиссии"
        + "\nУсловия снятия со счёта: " + "Снятие без комиссии");
  }

  @Override
  protected double getWithdrawalComission(double amount) {
    return 0;
  }

  @Override
  protected double getDepositComission(double amount) {
    return 0;
  }
}
