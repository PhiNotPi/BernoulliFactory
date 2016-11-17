package opCoin;

import main.Coin;

public class Mult extends Coin {

  Coin x;
  Coin y;

  public Mult(Coin x, Coin y) {
    super();
    this.x = x;
    this.y = y;
  }

  @Override
  public int next() {
    if (x.next() == 0) {
      return 0;
    }
    return y.next();
  }

}
