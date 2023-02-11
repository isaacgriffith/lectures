from Duck         import Duck
from FlyWithWings import FlyWithWings
from Quack        import Quack

class RedheadDuck(Duck):

    def __init__(self):
        super(RedheadDuck, self).__init__()
        self.setFlyBehavior(FlyWithWings())
        self.setQuackBehavior(Quack())

    def display(self):
        print "I'm a Redhead duck."
