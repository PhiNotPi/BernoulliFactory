package main;

public class SampleBMC extends BinaryMarkovChain {
  int sampleState = 0;
  int[][] count = new int[2][2];

  public void addSample(int sample) {
    count[sampleState][sample]++;
    sampleState = sample;
  }

  @Override
  public double p0() {
    return (double) count[0][1] / (count[0][0] + count[0][1]);
  }

  @Override
  public double p1() {
    return (double) count[1][1] / (count[1][0] + count[1][1]);
  }

}
