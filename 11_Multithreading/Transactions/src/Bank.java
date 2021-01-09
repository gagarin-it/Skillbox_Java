import java.util.HashMap;
import java.util.Random;

public class Bank
{

    private HashMap<String, Account> accounts;
    private final Random random = new Random();

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount)
    {
        if(accounts.get(fromAccountNum).isWithoutBlockAcc() && accounts.get(fromAccountNum).isWithoutBlockAcc()) {
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);

            if (amount > 50000) {
                try {
                    if (isFraud(fromAccountNum, toAccountNum, amount)) {
                        accounts.get(fromAccountNum).setWithoutBlockAcc(false);
                        accounts.get(toAccountNum).setWithoutBlockAcc(false);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Один или оба счёта заблокированны");
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum)
    {
        return accounts.get(accountNum).getMoney();
    }
}
