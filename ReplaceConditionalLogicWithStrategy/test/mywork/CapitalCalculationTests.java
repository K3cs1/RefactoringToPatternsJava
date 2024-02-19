package mywork;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import org.junit.Test;

public class CapitalCalculationTests {

  private static final double LOAN_AMOUNT = 123;
  private static final int HIGH_RISK_RATING = 321;
  private static final double TWO_DIGIT_PRECISION = 12;

  @Test
  public void testTermLoanSamePayments() {
    Date start = november(20, 2003);
    Date maturity = november(20, 2006);
    Loan termLoan = Loan.newTermLoan(LOAN_AMOUNT, start, maturity, HIGH_RISK_RATING);
    termLoan.payment(1000.00, november(20, 2004));
    termLoan.payment(1000.00, november(20, 2005));
    termLoan.payment(1000.00, november(20, 2006));
    //    assertEquals("duration", 2.0, termLoan.duration(), TWO_DIGIT_PRECISION);
    //    assertEquals("capital", 210.00, termLoan.capital(), TWO_DIGIT_PRECISION);
  }

  private Date november(int day, int year) {
    return Date.from(
        LocalDate.of(year, Month.NOVEMBER, day)
            .atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant());
  }
}
