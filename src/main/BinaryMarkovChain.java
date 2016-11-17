package main;

import java.util.ArrayList;

public abstract class BinaryMarkovChain extends Coin {
  public abstract double p0();

  public abstract double p1();

  int state = 0;

  public int next() {
    age++;
    if (state == 0) {
      if (rand.nextDouble() < p0()) {
        state = 1;
      } else {
        state = 0;
      }
    } else {
      if (rand.nextDouble() < p1()) {
        state = 1;
      } else {
        state = 0;
      }
    }
    return state;
  }

  public double[] stableDist() {
    double[] res = new double[2];
    res[1] = p0() / (1 + p0() - p1());
    res[0] = 1 - res[1];
    return res;
  }

  public double effHalf() {
    double[] dist = stableDist();
    return p0() * (1 - p0()) * dist[0] + p1() * (1 - p1()) * dist[1];
  }

  public double effTimes() {
    double[] dist = stableDist();
    return Math.min(dist[0], dist[1]);
  }

  public void reset() {
    state = 0;
    all = new ArrayList<Integer>();
    x = new ArrayList<Integer>();
    y = new ArrayList<Integer>();
    factory = new ArrayList<Integer>();
  }

  ArrayList<Integer> all = new ArrayList<Integer>();
  ArrayList<Integer> x = new ArrayList<Integer>();
  ArrayList<Integer> y = new ArrayList<Integer>();
  ArrayList<Integer> factory = new ArrayList<Integer>();
  double expected = 0;

  public void runHalf(int iter) {
    reset();
    expected = effHalf() * all.size();
    for (int i = 0; i < iter; i++) {
      int f = next();
      all.add(f);
      if (state == 0) {
        x.add(f);
        if (x.size() % 2 == 0) {
          if (x.get(x.size() - 1) != x.get(x.size() - 2)) {
            factory.add(x.get(x.size() - 1));
          }
        }
      } else {
        y.add(f);
        if (y.size() % 2 == 0) {
          if (y.get(y.size() - 1) != y.get(y.size() - 2)) {
            factory.add(y.get(y.size() - 1));
          }
        }
      }
      state = f;
    }
  }

  public void runTimes(int iter) {
    reset();
    expected = effTimes() * all.size();
    for (int i = 0; i < iter; i++) {
      int f = next();
      all.add(f);
      if (state == 0) {
        x.add(f);
        if (x.size() <= y.size()) {
          if (x.get(x.size() - 1) == 1 && y.get(x.size() - 1) == 1) {
            factory.add(1);
          } else {
            factory.add(0);
          }
        }
      } else {
        y.add(f);
        if (y.size() <= x.size()) {
          if (x.get(y.size() - 1) == 1 && y.get(y.size() - 1) == 1) {
            factory.add(1);
          } else {
            factory.add(0);
          }
        }
      }
      state = f;
    }
  }

  public void printFactory() {
    for (int i = 0; i < all.size(); i++) {
      System.out.print(all.get(i));
    }
    System.out.println();
    for (int i = 0; i < x.size(); i++) {
      System.out.print(x.get(i));
    }
    System.out.println();
    for (int i = 0; i < y.size(); i++) {
      System.out.print(y.get(i));
    }
    System.out.println();
    for (int i = 0; i < factory.size(); i++) {
      System.out.print(factory.get(i));
    }
    System.out.println();
    System.out.println(factory.size() + " " + expected);
  }

  public int sampleSD() {
    int count = 0;
    int initstate = state;
    while (state == initstate) {
      count++;
      next();
    }
    while (count > 0) {
      if (state == initstate) {
        return state;
      }
      next();
      count--;
    }
    if (state != initstate) {
      return state;
    }
    return 1 - sampleSD();
  }

  public double pSD() {
    int total = 0;
    int initAge = age;
    for (int i = 0; i < 100000; i++) {
      total += sampleSD();
    }
    sdEff = (age - initAge) * 1.0 / 100000;
    return total * 1.0 / 100000;
  }

  double sdEff = 0;

}
