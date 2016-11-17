package main;

import java.util.Random;

public abstract class Coin {
  public static Random rand = new Random();
  public int age = 0;

  public abstract int next();
}
