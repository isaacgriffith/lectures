from Duck    import Duck
from CantFly import CantFly
from Squeak  import Squeak

class RubberDuck(Duck):

    def __init__(self):
        super(RubberDuck, self).__init__()
        self.setFlyBehavior(CantFly())
        self.setQuackBehavior(Squeak())

    def display(self):
        print "I'm a rubber duckie."
