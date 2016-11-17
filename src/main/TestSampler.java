package main;

public class TestSampler {

  iidCoin x;
  iidCoin y;

  public TestSampler(iidCoin x, iidCoin y) {
    super();
    this.x = x;
    this.y = y;
  }

  public double pSD() {
    int total = 0;
    for (int i = 0; i < 100000; i++) {
      total += nextSD();
    }
    return total * 1.0 / 100000;
  }

  public int nextSD() {
    if (sampleRemSD() == 0) {
      return 0;
    }
    if (y.next() == 1) {
      return 1;
    }
    return 1 - nextSD();
  }

  int sampleRemSD() {
    int a;
    int b;
    do {
      a = x.next();
      b = y.next();
    } while (a == 0 && b == 1);
    if (a + b == 0) {
      return 0;
    }
    return 1;
  }

  public int nextQuo() {
    if (x.next() == 1) {
      return 1;
    }
    return remQuo();
  }

  public int remQuo() {
    int a;
    int b;
    do {
      b = y.next();
      if (b == 0) {
        return 0;
      }
      a = nextQuo();
    } while (a == 1 && b == 1);
    if (a == 1 && b == 0) {
      return 0;
    }
    return 1;
  }

  public double pRemQuo() {
    int total = 0;
    for (int i = 0; i < 100000; i++) {
      total += remQuo();
    }
    return total * 1.0 / 100000;
  }
}
