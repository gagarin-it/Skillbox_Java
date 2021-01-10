import java.util.HashMap;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Bank bank = new Bank();
    HashMap<String, Account> accounts = new HashMap<>();
    accounts.put("1", new Account("1", 110000));
    accounts.put("2", new Account("2", 220000));
    accounts.put("3", new Account("3", 330000));
    accounts.put("4", new Account("4", 440000));
    accounts.put("5", new Account("5", 150000));
    accounts.put("6", new Account("6", 260000));
    accounts.put("7", new Account("7", 370000));
    accounts.put("8", new Account("8", 480000));
    accounts.put("9", new Account("9", 190000));
    accounts.put("10", new Account("10", 150000));
    accounts.put("11", new Account("11", 250000));
    accounts.put("12", new Account("12", 350000));
    accounts.put("13", new Account("13", 450000));
    bank.setAccounts(accounts);

    System.out.println(
        "Сумма на счётах в банке: " + bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum()
            + " руб.");

    bank.getAccounts()
        .forEach((k, v) -> System.out.printf("Баланс счёта №%s: %d руб.\n", v.getAccNumber(), v.getMoney()));

    Thread oneThead = new Thread(() -> {
      bank.transfer("1", "2", 40000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      System.out.println("Баланс счёта №2: " + bank.getBalance("2"));
      bank.transfer("4", "1", 60000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      System.out.println("Баланс счёта №4: " + bank.getBalance("4"));
      bank.transfer("4", "1", 60000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      System.out.println("Баланс счёта №4: " + bank.getBalance("4"));
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    oneThead.start();
    oneThead.join();

    Thread twoThead = new Thread(() -> {
      bank.transfer("4", "1", 60000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      System.out.println("Баланс счёта №4: " + bank.getBalance("4"));
      bank.transfer("13", "1", 60000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      System.out.println("Баланс счёта №13: " + bank.getBalance("13"));
      bank.transfer("12", "11", 60000);
      System.out.println("Баланс счёта №11: " + bank.getBalance("11"));
      System.out.println("Баланс счёта №12: " + bank.getBalance("12"));
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    twoThead.start();
    twoThead.join();

    Thread threeThead = new Thread(() -> {
      bank.transfer("11", "4", 60000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("11"));
      System.out.println("Баланс счёта №4: " + bank.getBalance("12"));
      bank.transfer("8", "1", 60000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      System.out.println("Баланс счёта №8: " + bank.getBalance("8"));
      bank.transfer("12", "11", 60000);
      System.out.println("Баланс счёта №11: " + bank.getBalance("11"));
      System.out.println("Баланс счёта №12: " + bank.getBalance("12"));
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    });
    threeThead.start();
    threeThead.join();

    Thread fourThead = new Thread(() -> {
      bank.transfer("11", "4", 60000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("11"));
      System.out.println("Баланс счёта №4: " + bank.getBalance("12"));
      bank.transfer("11", "4", 60000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("11"));
      System.out.println("Баланс счёта №4: " + bank.getBalance("12"));
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    });
    fourThead.start();
    fourThead.join();

    System.out.println(
        "Сумма на счётах в банке: " + bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum()
            + " руб.");
  }

}
