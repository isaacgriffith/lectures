class Duck(object):

    def __init__(self):
        self.flyBehavior   = None
        self.quackBehavior = None

    def display(self):
        pass

    def performFly(self):
        self.flyBehavior.fly()

    def performQuack(self):
        self.quackBehavior.quack()

    def swim(self):
        print "Swim! Swim! Swim!"

    def setFlyBehavior(self, flyBehavior):
        self.flyBehavior = flyBehavior

    def setQuackBehavior(self, quackBehavior):
        self.quackBehavior = quackBehavior
