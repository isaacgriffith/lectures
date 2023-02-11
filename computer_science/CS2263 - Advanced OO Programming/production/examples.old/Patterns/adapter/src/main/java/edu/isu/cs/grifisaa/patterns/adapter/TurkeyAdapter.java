package edu.isu.cs.grifisaa.patterns.adapter;

public class TurkeyAdapter implements Duck {

  Turkey turkey;

  /**
   * We pass in the reference to the object that we are adapting
   */
  public TurkeyAdapter(Turkey turkey) {
    this.turkey = turkey;
  }

  /**
   * This one is simple, we only delegate from quack to a Turkey's gobble()
   */
  public void quack() {
    turkey.gobble();
  }

  /**
   * Even through both interfaces have a fly() method, Turkeys fly in short spurts --
   * they can't do long-distance flying like ducks. To map between a Duck's fly() method
   * and a Turkey's, we need to call the Turkey's fly() method five times to make up for
   * it.
   */
  @Override
  public void fly() {
    for (int i = 0; i < 5; i++) {
      turkey.fly();
    }
  }
}
