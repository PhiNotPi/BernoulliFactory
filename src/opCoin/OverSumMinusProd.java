package opCoin;

import main.Coin;

public class OverSumMinusProd extends Coin {
  // (x)/(x+y-xy)
  // closely related to (1-x)/(1-xy)
  Coin x;
  Coin y;

  public OverSumMinusProd(Coin x, Coin y) {
    super();
    this.x = x;
    this.y = y;
  }

  @Override
  public int next() {
    int a;
    int b;
    do {
      a = x.next();
      if (a == 1) {
        return 1;
      }
      b = y.next();
    } while (b == 0);
    return 0;
  }

}
