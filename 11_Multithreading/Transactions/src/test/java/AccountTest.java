import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тест класса Account")
public class AccountTest {

  private Account account;
  private static final String NOT_EXPECTED_BALANCE_MESSAGE = "Баланс счёта не соответствует ожидаемому";
  private static final String NOT_EXPECTED_NUMBER_ACC_MESSAGE = "Баланс счёта не соответствует ожидаемому";
  private static final String NOT_EXPECTED_BLOCK_ACC_MESSAGE = "Флаг блокировки счёта не соответствует ожидаемому";
  private static final double DELTA = 0.01;

  @BeforeEach
  protected void setUp() {
    String accountNumber = "1";
    long money = 100_000;
    account = new Account(accountNumber, money);
  }

  @Test
  @DisplayName("Метод setMoney")
  void setMoney() {
    account.setMoney(50_000);
    assertEquals(50_000, account.getMoney(), DELTA, NOT_EXPECTED_BALANCE_MESSAGE);
  }

  @Test
  @DisplayName("Метод setAccNumber")
  void setAccNumber() {
    account.setAccNumber("10");
    assertEquals("10", account.getAccNumber(), NOT_EXPECTED_NUMBER_ACC_MESSAGE);
  }

  @Test
  @DisplayName("Метод setWithoutBlockAcc")
  void setWithoutBlockAcc() {
    account.setWithoutBlockAcc(false);
    assertFalse(account.isWithoutBlockAcc(), NOT_EXPECTED_BLOCK_ACC_MESSAGE);
  }
}