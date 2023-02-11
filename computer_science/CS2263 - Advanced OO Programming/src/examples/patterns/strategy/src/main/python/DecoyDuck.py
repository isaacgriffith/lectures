from Duck    import Duck
from CantFly import CantFly
from Silence import Silence

class DecoyDuck(Duck):

    def __init__(self):
        super(DecoyDuck, self).__init__()
        self.setFlyBehavior(CantFly())
        self.setQuackBehavior(Silence())

    def display(self):
        print "I'm a decoy duck."
