package opCoin;

import main.Coin;

public class Pow extends Coin {
  // x^y
  Coin x;
  int y;
  Coin expr;

  public Pow(Coin x, int exp) {
    super();
    this.x = x;
    this.y = exp;
    this.expr = new Mult(x, new Pow(x, y - 1));
  }

  @Override
  public int next() {
    if (y == 0) {
      return 1;
    } else if (y == 1) {
      return x.next();
    }
    return expr.next();
  }

}
