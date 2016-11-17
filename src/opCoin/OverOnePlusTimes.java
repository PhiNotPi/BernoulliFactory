package opCoin;

import main.Coin;

public class OverOnePlusTimes extends Coin {
  // x/(1+xy)
  Coin x;
  Coin y;
  Coin expr;

  public OverOnePlusTimes(Coin x, Coin y) {
    super();
    this.x = x;
    this.y = y;
    this.expr = new Mult(x, new Neg(new Mult(y, this)));
  }

  @Override
  public int next() {
    return expr.next();
  }
}
