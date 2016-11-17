package main;

import opCoin.*;

public class Main {

  public static void main(String[] args) {
    Coin c = new OverSum(new iidCoin(0.3), new iidCoin(0.2));
    // should compute 0.3 / (0.3 + 0.2) = 0.6
    int total = 0;
    for (int i = 0; i < 1000000; i++) {
      int res = c.next();
      total += res;
      if (i < 100) {
        System.out.print(res);
      }
    }
    System.out.println();
    System.out.println(total * 1.0 / 1000000);
  }

}
