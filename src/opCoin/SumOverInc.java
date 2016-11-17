package opCoin;

import main.Coin;

public class SumOverInc extends Coin {
  // (x+y)/(x+1)
  Coin x;
  Coin y;
  Coin expr;

  public SumOverInc(Coin x, Coin y) {
    super();
    this.x = x;
    this.y = y;
    this.expr = new Or(y, new Mult(x, new InvPoly(x, 1)));
  }

  @Override
  public int next() {
    return expr.next();
  }
}
