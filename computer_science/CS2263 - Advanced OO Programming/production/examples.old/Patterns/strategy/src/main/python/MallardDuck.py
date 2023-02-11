from Duck         import Duck
from FlyWithWings import FlyWithWings
from Quack        import Quack

class MallardDuck(Duck):

    def __init__(self):
        super(MallardDuck, self).__init__()
        self.setFlyBehavior(FlyWithWings())
        self.setQuackBehavior(Quack())

    def display(self):
        print "I'm a Mallard duck."
