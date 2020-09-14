import Accounts.BankAccount;
import Accounts.CardAccount;
import Accounts.DepositeAccount;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    BankAccount bankAccount = new BankAccount(10000);
    System.out.println(bankAccount.accountBalance());
    bankAccount.addMoney(150.50);
    System.out.println(bankAccount.accountBalance());
    bankAccount.addMoney(155.50);
    System.out.println(bankAccount.accountBalance());
    bankAccount.removalMoney(13333.6);
    System.out.println(bankAccount.accountBalance());
    System.out.println("_____________________________________");
    DepositeAccount depositeAccount = new DepositeAccount(1600.50);
    System.out.println(depositeAccount.accountBalance());
    depositeAccount.addMoney(1005.55);
    System.out.println(depositeAccount.accountBalance());
    depositeAccount.removalMoney(1325.5);
    System.out.println(depositeAccount.accountBalance());
    System.out.println("_____________________________________");
    CardAccount cardAccount = new CardAccount(50000);
    System.out.println(cardAccount.accountBalance());
    cardAccount.addMoney(9850);
    System.out.println(cardAccount.accountBalance());
    cardAccount.removalMoney(1000);
    System.out.println(cardAccount.accountBalance());
    cardAccount.removalMoney(59000);
    System.out.println(cardAccount.accountBalance());

    System.out.println("_____________________________________");
    System.out.println(cardAccount.accountBalance());
    System.out.println(bankAccount.accountBalance());
    cardAccount.send(bankAccount, 58257.42);
    System.out.println(cardAccount.accountBalance());
    System.out.println(bankAccount.accountBalance());
  }
}
