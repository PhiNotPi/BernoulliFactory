package main;

public class FixedBMC extends BinaryMarkovChain {

  private double p0;
  private double p1;

  public FixedBMC(double p0, double p1) {
    super();
    this.p0 = p0;
    this.p1 = p1;
  }

  @Override
  public double p0() {
    return p0;
  }

  @Override
  public double p1() {
    return p1;
  }

}
