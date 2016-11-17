package opCoin;

import main.Coin;
import main.iidCoin;

public class Const extends Coin {

  Coin fair;
  double p;

  public Const(double p, Coin x) {
    super();
    this.p = p;
    this.fair = new Fair(x);
  }

  public Const(double p) {
    // cheating but easier
    super();
    this.p = p;
    this.fair = new iidCoin(0.5);
  }

  @Override
  public int next() {
    double val = p;
    while (val > 0 && val < 1) {
      val *= 2;
      if (fair.next() == 1) {
        val--;
      }
    }
    if (val > 0) {
      return 1;
    }
    return 0;
  }

}
