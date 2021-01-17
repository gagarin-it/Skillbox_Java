import java.util.HashMap;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bank {

  private HashMap<String, Account> accounts;
  private final Random random = new Random();
  private final Logger logger = LogManager.getRootLogger();

  public HashMap<String, Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(HashMap<String, Account> accounts) {
    this.accounts = accounts;
  }

  public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
      throws InterruptedException {
    Thread.sleep(10);
    return random.nextBoolean();
  }

  public void transfer(String fromAccountNum, String toAccountNum, long amount) {
    synchronized (fromAccountNum.compareTo(toAccountNum) > 0 ? fromAccountNum : toAccountNum) {
      synchronized (fromAccountNum.compareTo(toAccountNum) > 0 ? toAccountNum : fromAccountNum) {
        if (accounts.get(fromAccountNum).getMoney() - amount > 0) {
          if (accounts.get(fromAccountNum).isWithoutBlockAcc() && accounts.get(toAccountNum)
              .isWithoutBlockAcc()) {
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
            logger.info("Проведена транзакция №" + Thread.currentThread().getName().replace(" THEAD", "") + " на сумму "
                + amount + ", со счёта №" + fromAccountNum + ", на счёт №" + toAccountNum);

            if (amount > 50000) {
              try {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                  accounts.get(fromAccountNum).setWithoutBlockAcc(false);
                  accounts.get(toAccountNum).setWithoutBlockAcc(false);
                }
              } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
              }
            }
          } else if (!accounts.get(fromAccountNum).isWithoutBlockAcc()) {
            logger.warn("Счёт №" + fromAccountNum + " заблокирован, находится на проверке в СБ");
          } else if (!accounts.get(toAccountNum).isWithoutBlockAcc()) {
            logger.warn("Счёт №" + toAccountNum + " заблокирован, находится на проверке в СБ");
          }
        } else {
          logger.warn("На счёте №" + fromAccountNum + " недостаточно средств для транзакции");
        }
      }
    }
  }

  public long getBalance(String accountNum) {
    logger.info("Запрошен баланс счёта № " + accountNum + ": " + accounts.get(accountNum).getMoney());
    return accounts.get(accountNum).getMoney();
  }
}