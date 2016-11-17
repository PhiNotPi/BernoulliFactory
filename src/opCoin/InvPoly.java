package opCoin;

import main.Coin;

public class InvPoly extends Coin {
  // (1-x)/(1-x^y) = 1/(1+x+x^2+...)
  Coin x;
  int y;
  Coin expr;

  public InvPoly(Coin x, int exp) {
    super();
    this.x = x;
    this.y = exp;
    this.expr = new Or(new Neg(x), new Mult(new Pow(x, exp), this));
  }

  @Override
  public int next() {
    // if (x.next() == 0) {
    // return 1;
    // } else {
    // return (new Mult(new Pow(x, exp), this)).next();
    // }
    return expr.next();
  }

}
