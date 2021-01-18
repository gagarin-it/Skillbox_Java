import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankTest {

  private static final String NOT_EXPECTED_MAP_ACC_MESSAGE = "Карта счетов не соответствует ожидаемой";
  private static final String NOT_EXPECTED_BALANCE_ACC_MESSAGE = "Баланс счета не соответствует ожидаемому";
  private static final String NOT_EXPECTED_IS_FRAG_MESSAGE = "Флаг проверки СБ не соответствует ожидаемому";
  private Bank bank;
  HashMap<String, Account> accounts;


  @BeforeEach
  protected void setUp() {
    bank = spy(new Bank());
    accounts = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      accounts.put("" + i, new Account("" + i, ThreadLocalRandom.current().nextLong(40000, 400000)));
    }
    bank.setAccounts(accounts);
  }

  @Test
  @DisplayName("Метод setAccounts")
  void setAccounts() {
    HashMap<String, Account> accountsExpected = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      accountsExpected.put("" + i, new Account("acc" + i, ThreadLocalRandom.current().nextLong(40000, 400000)));
    }
    bank.setAccounts(accountsExpected);
    assertEquals(accountsExpected, bank.getAccounts(), NOT_EXPECTED_MAP_ACC_MESSAGE);
  }

  @Test
  @DisplayName("Метод transfer")
  void transfer() {
    long amountTransfer = 30_555;
    long expectedBalanceAccountOne = bank.getBalance("1") - amountTransfer;
    long expectedBalanceAccountTwo = bank.getBalance("6") + amountTransfer;
    bank.transfer("1", "6",amountTransfer);
    assertEquals(expectedBalanceAccountOne,bank.getBalance("1"),NOT_EXPECTED_BALANCE_ACC_MESSAGE);
    assertEquals(expectedBalanceAccountTwo,bank.getBalance("6"),NOT_EXPECTED_BALANCE_ACC_MESSAGE);
  }

  @Test
  @DisplayName("Метод isFraud с возвратом true")
  void isFraudTrue() throws InterruptedException {
    try {
      when(bank.isFraud("fromAccountNum","toAccountNum",0L)).thenReturn(true);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertTrue(bank.isFraud("fromAccountNum","toAccountNum",0L), NOT_EXPECTED_IS_FRAG_MESSAGE);
  }

  @Test
  @DisplayName("Метод isFraud с возвратом false")
  void isFraudFalse() throws InterruptedException {
    try {
      when(bank.isFraud("fromAccountNum","toAccountNum",0L)).thenReturn(false);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertFalse(bank.isFraud("fromAccountNum","toAccountNum",0L), NOT_EXPECTED_IS_FRAG_MESSAGE);
  }
}