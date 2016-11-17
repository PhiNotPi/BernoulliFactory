package opCoin;

import main.Coin;

public class Fair extends Coin {

  Coin x;

  public Fair(Coin x) {
    super();
    this.x = x;
  }

  @Override
  public int next() {
    int a;
    int b;
    do {
      a = x.next();
      b = x.next();
    } while (a == b);
    return a;
  }

}
