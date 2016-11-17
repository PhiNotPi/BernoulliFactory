package opCoin;

import main.Coin;

public class OverSum extends Coin {
  // x/(x+y)
  Coin x;
  Coin y;
  Coin expr;

  public OverSum(Coin x, Coin y) {
    super();
    this.x = x;
    this.y = y;
    this.expr = new Or(new Mult(new Neg(y), new OverSumMinusProd(x, y)),
        new Mult(x, new Neg(this)));
  }

  @Override
  public int next() {
    return expr.next();
  }

}
