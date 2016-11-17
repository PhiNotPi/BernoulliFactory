package opCoin;

import main.Coin;

public class Or extends Coin {
  // x+y-xy = 1-(1-x)(1-y)
  Coin x;
  Coin y;

  public Or(Coin x, Coin y) {
    super();
    this.x = x;
    this.y = y;
  }

  @Override
  public int next() {
    if (x.next() == 1) {
      return 1;
    }
    return y.next();
  }

}
