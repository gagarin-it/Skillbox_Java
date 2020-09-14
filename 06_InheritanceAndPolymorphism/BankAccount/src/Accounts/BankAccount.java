package Accounts;

public class BankAccount {

    protected double money;
    private BankAccount receiver;

    public BankAccount(double money) {
        this.money = money;
    }

    public double accountBalance() {
        return money;
    }

    public void addMoney(double addMoney) {
        this.money = money + addMoney;
    }

    public boolean removalMoney(double removalMoney) {
        if (this.money - removalMoney >= 0.0) {
            this.money = money - removalMoney;
            return true;
        }
        System.out.println("На счёте не достаточно средств для снятия");
        return false;
    }

    public boolean send(BankAccount receiver, double amount) {
        if (removalMoney(amount)) {
            receiver.addMoney(amount);
            return true;
        }
        return false;
    }
}
