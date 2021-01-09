import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    Bank bank = new Bank();
    HashMap<String, Account> accounts = new HashMap<>();
    accounts.put("1", new Account("1", 100000));
    accounts.put("2", new Account("2", 200000));
    accounts.put("3", new Account("3", 300000));
    accounts.put("4", new Account("4", 400000));
    bank.setAccounts(accounts);

    System.out.println("Сумма на счёте в банке: " + bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum());

    System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
    System.out.println("Баланс счёта №2: " + bank.getBalance("2"));
    System.out.println("Баланс счёта №3: " + bank.getBalance("3"));
    System.out.println("Баланс счёта №4: " + bank.getBalance("4"));

    bank.transfer("1","2",40000);
    System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
    System.out.println("Баланс счёта №2: " + bank.getBalance("2"));

    bank.transfer("4","1",60000);
    System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
    System.out.println("Баланс счёта №4: " + bank.getBalance("4"));
    bank.transfer("4","1",60000);
    System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
    System.out.println("Баланс счёта №4: " + bank.getBalance("4"));
    bank.transfer("4","1",60000);
    System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
    System.out.println("Баланс счёта №4: " + bank.getBalance("4"));

      System.out.println("Сумма на счёте в банке: " + bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum());
  }

}
