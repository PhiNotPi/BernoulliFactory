package opCoin;

import main.Coin;

public class Multi1 extends Coin {
  // (x(1-y(1-z))+y)/(yz+1) = (xyz-xy+x+y)/(1+yz)
  // x=0 -> y/(1+yz)
  // x=1 -> 1
  // y=0 -> x
  // y=1 -> (xz+1)/(z+1)
  // z=0 -> x+z-xz = 1-(1-x)(1-z) = x OR z
  // z=1 -> (x+y)/(y+1)
  // z=1, x=wy -> (w+1)y/(y+1)
  Coin x;
  Coin y;
  Coin z;
  Coin expr;

  public Multi1(Coin x, Coin y, Coin z) {
    super();
    this.x = x;
    this.y = y;
    this.z = z;
    this.expr = new Or(x, new OverOnePlusTimes(y, z));
  }

  @Override
  public int next() {
    return expr.next();
  }

}
