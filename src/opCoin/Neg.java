package opCoin;

import main.Coin;

public class Neg extends Coin {

  Coin x;

  public Neg(Coin x) {
    super();
    this.x = x;
  }

  @Override
  public int next() {
    return 1 - x.next();
  }

}
