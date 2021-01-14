import java.util.HashMap;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Bank bank = new Bank();
    HashMap<String, Account> accounts = new HashMap<>();
    accounts.put("1", new Account("1", 11000));
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
    accounts.put("14", new Account("14", 80000));
    accounts.put("15", new Account("15", 10000));
    accounts.put("16", new Account("16", 40000));
    accounts.put("17", new Account("17", 155444));
    accounts.put("18", new Account("18", 95123));
    accounts.put("19", new Account("19", 752000));
    accounts.put("20", new Account("20", 5000));
    bank.setAccounts(accounts);

    System.out.println(
        "Сумма на счётах в банке: " + bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum()
            + " руб.");

    bank.getAccounts()
        .forEach((k, v) -> System.out.printf("\t\tБаланс счёта №%s: %d руб.\n", v.getAccNumber(), v.getMoney()));

    Thread oneThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("1", "2", 40000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      System.out.println("Баланс счёта №2: " + bank.getBalance("2"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"ONE THEAD");

    Thread twoThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("2", "1", 150000);
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      System.out.println("Баланс счёта №2: " + bank.getBalance("2"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"TWO THEAD");

    Thread threeThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("5", "6", 50000);
      System.out.println("Баланс счёта №5: " + bank.getBalance("5"));
      System.out.println("Баланс счёта №6: " + bank.getBalance("6"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"THREE THEAD");

    Thread fourThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("10", "20", 150000);
      System.out.println("Баланс счёта №10: " + bank.getBalance("10"));
      System.out.println("Баланс счёта №20: " + bank.getBalance("20"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"FOUR THEAD");

    Thread fiveThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("10", "20", 150000);
      System.out.println("Баланс счёта №10: " + bank.getBalance("10"));
      System.out.println("Баланс счёта №20: " + bank.getBalance("20"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"FIVE THEAD");

    Thread sixThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("10", "20", 150000);
      System.out.println("Баланс счёта №10: " + bank.getBalance("10"));
      System.out.println("Баланс счёта №20: " + bank.getBalance("20"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"SIX THEAD");

    Thread sevenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("10", "20", 150000);
      System.out.println("Баланс счёта №10: " + bank.getBalance("10"));
      System.out.println("Баланс счёта №20: " + bank.getBalance("20"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"SEVEN THEAD");

    Thread eightThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("3", "2", 20000);
      System.out.println("Баланс счёта №3: " + bank.getBalance("3"));
      System.out.println("Баланс счёта №2: " + bank.getBalance("2"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"EIGHT THEAD");

    Thread nineThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("3", "1", 100000);
      System.out.println("Баланс счёта №3: " + bank.getBalance("3"));
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"NINE THEAD");

    Thread tenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("20", "3", 200000);
      System.out.println("Баланс счёта №3: " + bank.getBalance("3"));
      System.out.println("Баланс счёта №20: " + bank.getBalance("20"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"TEN THEAD");

    Thread elevenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("5", "6", 45000);
      System.out.println("Баланс счёта №5: " + bank.getBalance("5"));
      System.out.println("Баланс счёта №6: " + bank.getBalance("6"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"ELEVEN THEAD");

    Thread twelveThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("6", "7", 150000);
      System.out.println("Баланс счёта №6: " + bank.getBalance("6"));
      System.out.println("Баланс счёта №7: " + bank.getBalance("7"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"TWELVE THEAD");

    Thread thirteenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("7", "8", 50000);
      System.out.println("Баланс счёта №7: " + bank.getBalance("7"));
      System.out.println("Баланс счёта №8: " + bank.getBalance("8"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"THIRTEEN THEAD");

    Thread fourteenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("8", "11", 150000);
      System.out.println("Баланс счёта №8: " + bank.getBalance("8"));
      System.out.println("Баланс счёта №11: " + bank.getBalance("11"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"FOURTEEN THEAD");

    Thread fiveteenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("11", "7", 150000);
      System.out.println("Баланс счёта №11: " + bank.getBalance("11"));
      System.out.println("Баланс счёта №7: " + bank.getBalance("7"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"FIVETEEN THEAD");

    Thread sixteenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("11", "12", 150000);
      System.out.println("Баланс счёта №11: " + bank.getBalance("11"));
      System.out.println("Баланс счёта №12: " + bank.getBalance("12"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"SIXTEEN THEAD");

    Thread seventeenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("12", "15", 100000);
      System.out.println("Баланс счёта №12: " + bank.getBalance("12"));
      System.out.println("Баланс счёта №15: " + bank.getBalance("15"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"SEVENTEEN THEAD");

    Thread eightteenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("19", "11", 200000);
      System.out.println("Баланс счёта №19: " + bank.getBalance("19"));
      System.out.println("Баланс счёта №11: " + bank.getBalance("11"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"EIGHTTEEN THEAD");

    Thread nineteenThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("19", "18", 200000);
      System.out.println("Баланс счёта №19: " + bank.getBalance("19"));
      System.out.println("Баланс счёта №18: " + bank.getBalance("18"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"NINETEEN THEAD");

    Thread twentyThead = new Thread(() -> {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      bank.transfer("19", "1", 200000);
      System.out.println("Баланс счёта №19: " + bank.getBalance("19"));
      System.out.println("Баланс счёта №1: " + bank.getBalance("1"));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    },"TWENTY THEAD");

    oneThead.start();
    twoThead.start();
    threeThead.start();
    fourThead.start();
    fiveThead.start();
    sixThead.start();
    sevenThead.start();
    eightThead.start();
    nineThead.start();
    tenThead.start();
    elevenThead.start();
    twelveThead.start();
    thirteenThead.start();
    fourteenThead.start();
    fiveteenThead.start();
    sixteenThead.start();
    seventeenThead.start();
    eightteenThead.start();
    nineteenThead.start();
    twentyThead.start();

    twentyThead.join();
    System.out.println(
        "Сумма на счётах в банке: " + bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum()
            + " руб.");
  }

}
