import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Bank bank = new Bank();
    HashMap<String, Account> accounts = new HashMap<>();
    List<Thread> threadList = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < 1000; i++) {
      accounts.put("" + i, new Account("" + i, (int) ((Math.random() * 150000) + Math.random() * 250000)));
    }
    bank.setAccounts(accounts);

    System.out.println(
        "Сумма на счётах в банке: " + bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum()
            + " руб.");

    bank.getAccounts()
        .forEach((k, v) -> System.out.printf("\t\tБаланс счёта №%s: %d руб.\n", v.getAccNumber(), v.getMoney()));

    for (int i = 0; i < 1000; i++) {
      String fromAccNum = "" + random.nextInt(accounts.size());
      String toAccNum = "" + random.nextInt(accounts.size());
      Thread thread = new Thread(() -> {
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        bank.transfer(fromAccNum, toAccNum, 40000 + (int)Math.random() * 20000);
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }, i +" THEAD");
      thread.start();
      threadList.add(thread);
    }

    for (Thread thread : threadList) {
      thread.join();
    }

    System.out.println(
        "Сумма на счётах в банке: " + bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum()
            + " руб.");
  }
}