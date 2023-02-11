package edu.isu.cs.grifisaa.patterns.strategy;

public class MiniDuckSimulator {

    public static void main(String[] args) {

        Duck mallard = new MallardDuck();
        Duck rubberDuckie = new RubberDuck();
        Duck decoy = new DecoyDuck();

        Duck model = new ModelDuck();

        mallard.performQuack();
        mallard.performFly();

        rubberDuckie.performQuack();
        rubberDuckie.performFly();

        decoy.performQuack();
        decoy.performFly();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
