package mywork;

public class UnusedRiskFactors {

  private UnusedRiskFactors() {}

  public static UnusedRiskFactors getFactors(Loan loan) {
    return new UnusedRiskFactors();
  }

  public double forRating(double riskRating) {
    return 0.0;
  }
}
