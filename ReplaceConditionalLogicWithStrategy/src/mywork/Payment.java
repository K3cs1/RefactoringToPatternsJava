package mywork;

import java.util.Date;

public class Payment {

  private Date date;
  private double amount;

  public Payment() {
    this.amount = 0.0;
    this.date = new Date();
  }

  public Payment(double amount, Date date) {
    this.amount = amount;
    this.date = date;
  }

  public double amount() {
    return this.amount;
  }

  public Date date() {
    return this.date;
  }
}
