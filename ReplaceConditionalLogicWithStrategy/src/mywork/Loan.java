package mywork;

import java.util.Arrays;
import java.util.Date;

public class Loan {
  private double riskRating;
  private double outstanding;
  private double commitment;
  private Date maturity;
  private Date expiry;

  private final Date start;
  private CapitalStrategy capitalStrategy;
  private double unusedPercentage;
  private Payment payment;

  private Loan(
      double commitment,
      double outstanding,
      Date start,
      Date expiry,
      Date maturity,
      double riskRating,
      CapitalStrategy capitalStrategy) {
    this.start = start;
    this.capitalStrategy = capitalStrategy;
    this.commitment = commitment;
    this.outstanding = outstanding;
    this.riskRating = riskRating;
    this.maturity = maturity;
    this.expiry = expiry;
  }

  public static Loan newTermLoan(double commitment, Date start, Date maturity, int riskRating) {
    return new Loan(
        commitment, commitment, start, null, maturity, riskRating, new CapitalStrategyTermLoan());
  }

  public static Loan newRevolver(double commitment, Date start, Date expiry, double riskRating) {
    return new Loan(commitment, 0, start, expiry, null, riskRating, new CapitalStrategyRevolver());
  }

  public static Loan newAdvisedLine(double commitment, Date start, Date expiry, int riskRating) {
    if (riskRating > 3) {
      return null;
    }
    Loan advisedLine =
        new Loan(commitment, 0, start, expiry, null, riskRating, new CapitalStrategyAdvisedLine());
    advisedLine.setUnusedPercentage(0.1);
    return advisedLine;
  }

  private void setUnusedPercentage(double unusedPercentage) {
    this.unusedPercentage = unusedPercentage;
  }

  public double capital() {
    return capitalStrategy.capital(this);
  }

  public double duration() {
    return capitalStrategy.duration(this);
  }

  double getUnusedPercentage() {
    return unusedPercentage;
  }

  Date getExpiry() {
    return expiry;
  }

  Date getMaturity() {
    return maturity;
  }

  double getCommitment() {
    return commitment;
  }

  double outstandingRiskAmount() {
    return outstanding;
  }

  double unusedRiskAmount() {
    return (commitment - outstanding);
  }

  double getRiskRating() {
    return riskRating;
  }

  Date getToday() {
    return new Date();
  }

  Date getStart() {
    return this.start;
  }

  public Iterable<Payment> getPayments() {
    return Arrays.asList(this.payment);
  }

  public void payment(double amount, Date date) {
    this.payment = new Payment(amount, date);
  }
}
