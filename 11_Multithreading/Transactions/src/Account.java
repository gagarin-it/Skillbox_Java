public class Account
{
    private volatile long money;
    private volatile String accNumber;
    private volatile boolean withoutBlockAcc;


    public Account(String accNumber, long money) {
        this.money = money;
        this.accNumber = accNumber;
        this.withoutBlockAcc = true;
    }

    public long getMoney() {
        return money;
    }

    public synchronized void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public synchronized void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isWithoutBlockAcc() {
        return withoutBlockAcc;
    }

    public void setWithoutBlockAcc(boolean withoutBlockAcc) {
        this.withoutBlockAcc = withoutBlockAcc;
    }
}
