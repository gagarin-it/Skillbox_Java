import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

  private static Logger logger = LogManager.getRootLogger();

  public static void main(String[] args) {
    Bank bank = new Bank();
    HashMap<String, Account> accounts = new HashMap<>();
    List<Thread> threadList = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < 1000; i++) {
      long amountAccount = ThreadLocalRandom.current().nextLong(40000, 400000);
      accounts.put("" + i, new Account("" + i, amountAccount));
    }
    bank.setAccounts(accounts);
    int randomGetBalance = random.nextInt(accounts.size());
    System.out.println("Остаток по счёту №" + randomGetBalance + ": " + bank.getBalance(Integer.toString(randomGetBalance)));

    printBalanceBank(bank);
    printBalanceBankOnAccounts(bank);

    for (int i = 0; i < 1000; i++) {
      String fromAccNum = "" + random.nextInt(accounts.size());
      String toAccNum = "" + random.nextInt(accounts.size());
      long amountTransferred = ThreadLocalRandom.current().nextLong(30000, 52000);
      Thread thread = new Thread(() -> {
        bank.transfer(fromAccNum, toAccNum, amountTransferred);
      }, i + " THEAD");
      thread.start();
      threadList.add(thread);
    }

    for (Thread thread : threadList) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
        logger.error(e.getMessage());
      }
    }
    printBalanceBank(bank);
    System.out.println("Остаток по счёту №" + randomGetBalance + ": " + bank.getBalance(Integer.toString(randomGetBalance)));

  }

  public static void printBalanceBank(Bank bank) {
    System.out.println(
        "Сумма на счетах в банке: " + bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum()
            + " руб.");
  }

  public static void printBalanceBankOnAccounts(Bank bank) {
    bank.getAccounts()
        .forEach((k, v) -> System.out.printf("\t\tБаланс счёта №%s: %d руб.\n", v.getAccNumber(), v.getMoney()));
  }
}