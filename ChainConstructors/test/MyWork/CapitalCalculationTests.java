package MyWork;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class CapitalCalculationTests {

  @Test
  public void testTermLoanNoPayments() {
    double commitment = 1.0f;
    double riskRating = 2.0f;
    Date maturity = new Date();
    Loan termLoan = Loan.createTermLoan(commitment, riskRating, maturity);
    Assert.assertNotNull(termLoan);
  }

  @Test
  public void testTermLoanWithRiskAdjustedCapitalStrategy() {
    CapitalStrategyTermLoan riskAdjustedCapitalStrategy = new CapitalStrategyTermLoan();
    double commitment = 1.0f;
    double outstanding = 2.0f;
    double riskRating = 2.0f;
    Date maturity = new Date();
    Loan termLoan =
        Loan.createTermLoan(
            riskAdjustedCapitalStrategy, commitment, outstanding, riskRating, maturity);
    Assert.assertNotNull(termLoan);
  }
}
