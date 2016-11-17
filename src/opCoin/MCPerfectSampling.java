package opCoin;

import main.Coin;

public class MCPerfectSampling extends Coin {
  // x/(1+x-y)
  // see BinaryMarkovChain.sampleSD() for real implementation
  Coin x;
  Coin y;
  Coin expr;

  public MCPerfectSampling(Coin x, Coin y) {
    super();
    this.x = x;
    this.y = y;
    this.expr = new OverSum(x, new Neg(y));
  }

  @Override
  public int next() {
    return expr.next();
  }
}
