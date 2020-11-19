import java.text.SimpleDateFormat;
import java.util.Date;

public class Statement {

  private String typeAccount;
  private String numberAccount;
  private String currency;
  private Date transactionDate;
  private String transactionReference;
  private String transactionDescription;
  private Double depositMoney;
  private Double withdrawalMoney;

  public Statement(String typeAccount, String numberAccount, String currency,
      Date transactionDate, String transactionReference, String transactionDescription,
      Double depositMoney,
      Double withdrawalMoney) {
    this.typeAccount = typeAccount;
    this.numberAccount = numberAccount;
    this.currency = currency;
    this.transactionDate = transactionDate;
    this.transactionReference = transactionReference;
    this.transactionDescription = transactionDescription;
    this.depositMoney = depositMoney;
    this.withdrawalMoney = withdrawalMoney;
  }

  public String getTypeAccount() {
    return typeAccount;
  }

  public void setTypeAccount(String typeAccount) {
    this.typeAccount = typeAccount;
  }

  public String getNumberAccount() {
    return numberAccount;
  }

  public void setNumberAccount(String numberAccount) {
    this.numberAccount = numberAccount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Date getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }

  public String getTransactionReference() {
    return transactionReference;
  }

  public void setTransactionReference(String transactionReference) {
    this.transactionReference = transactionReference;
  }

  public String getTransactionDescription() {
    return transactionDescription;
  }

  public void setTransactionDescription(String transactionDescription) {
    this.transactionDescription = transactionDescription;
  }

  public Double getDepositMoney() {
    return depositMoney;
  }

  public void setDepositMoney(Double depositMoney) {
    this.depositMoney = depositMoney;
  }

  public Double getWithdrawalMoney() {
    return withdrawalMoney;
  }

  public void setWithdrawalMoney(Double withdrawalMoney) {
    this.withdrawalMoney = withdrawalMoney;
  }

  @Override
  public String toString() {
    return "Statement{" +
        "typeAccount='" + typeAccount + '\'' +
        ", numberAccount='" + numberAccount + '\'' +
        ", currency='" + currency + '\'' +
        ", transactionDate=" + (new SimpleDateFormat("dd.MM.yy")).format(transactionDate) +
        ", transactionReference='" + transactionReference + '\'' +
        ", transactionDescription='" + transactionDescription + '\'' +
        ", depositMoney=" + depositMoney +
        ", withdrawalMoney=" + withdrawalMoney +
        '}';
  }
}
