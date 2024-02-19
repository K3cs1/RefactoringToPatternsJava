package mywork;

public class RiskFactor {

  private RiskFactor() {}

  public static RiskFactor getFactors() {
    return new RiskFactor();
  }

  public double forRating(double riskRating) {
    return riskRating;
  }
}
