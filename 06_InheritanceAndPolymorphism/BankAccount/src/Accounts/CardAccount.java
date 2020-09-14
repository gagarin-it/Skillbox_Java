package Accounts;

public class CardAccount extends BankAccount {

    private static final double PERCENT_COMMISSION = 1;

    public CardAccount(double money) {
        super(money);
    }

    @Override
    public boolean removalMoney(double removalMoney) {
        double commissionForRemoval = removalMoney / 100 * PERCENT_COMMISSION;
        boolean notNegativeBalance = removalMoney + commissionForRemoval <= money;
        if (notNegativeBalance) {
            this.money = money - removalMoney - commissionForRemoval;
            return true;
        }
        System.out.println("Сумма снятия с комиссией превышает остаток на счёте");
        return false;
    }
}
