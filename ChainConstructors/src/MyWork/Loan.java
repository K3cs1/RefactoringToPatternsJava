package MyWork;

import java.util.Date;

public class Loan {

  private final double commitment;
  private final double outstanding;
  private final double riskRating;
  private final Date maturity;
  private final Date expiry;
  private CapitalStrategy capitalStrategy;

  public Loan(
      CapitalStrategy capitalStrategy,
      double commitment,
      double outstanding,
      double riskRating,
      Date maturity,
      Date expiry) {
    this.commitment = commitment;
    this.outstanding = outstanding;
    this.riskRating = riskRating;
    this.maturity = maturity;
    this.expiry = expiry;
    this.capitalStrategy = capitalStrategy;
    if (capitalStrategy == null) {
      if (expiry == null) {
        this.capitalStrategy = new CapitalStrategyTermLoan();
      } else if (maturity == null) {
        this.capitalStrategy = new CapitalStrategyRevolver();
      } else {
        this.capitalStrategy = new CapitalStrategyRCTL();
      }
    }
  }

  public static Loan createTermLoan(double commitment, double riskRating, Date maturity) {
    return new Loan(null, commitment, 0.00, riskRating, maturity, null);
  }

  public static Loan createTermLoan(
      CapitalStrategy capitalStrategy, double commitment, double riskRating, Date maturity) {
    return new Loan(capitalStrategy, commitment, 0.00, riskRating, maturity, null);
  }

  public static Loan createRevolver(
      double commitment, double outstanding, double riskRating, Date expiry) {
    return new Loan(null, commitment, outstanding, riskRating, null, expiry);
  }

  public static Loan createRevolver(
      CapitalStrategyTermLoan capitalStrategy,
      double commitment,
      double outstanding,
      double riskRating,
      Date expiry) {
    return new Loan(capitalStrategy, commitment, outstanding, riskRating, null, expiry);
  }

  public static Loan createRCTL(
      double commitment, double outstanding, double riskRating, Date maturity, Date expiry) {
    return new Loan(null, commitment, outstanding, riskRating, maturity, expiry);
  }

  public static Loan createRCTL(
      CapitalStrategyTermLoan capitalStrategy,
      double commitment,
      double outstanding,
      double riskRating,
      Date maturity,
      Date expiry) {
    return new Loan(capitalStrategy, commitment, outstanding, riskRating, maturity, expiry);
  }

  public static Loan createTermLoan(
      CapitalStrategyTermLoan riskAdjustedCapitalStrategy,
      double commitment,
      double outstanding,
      double riskRating,
      Date maturity) {
    return new Loan(
        riskAdjustedCapitalStrategy, commitment, outstanding, riskRating, maturity, null);
  }

  public CapitalStrategy getCapitalStrategy() {
    return capitalStrategy;
  }
}
