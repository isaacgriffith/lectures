from DecoyDuck   import DecoyDuck
from MallardDuck import MallardDuck
from RedheadDuck import RedheadDuck
from RubberDuck  import RubberDuck

import random

class DuckSimulator(object):

    def __init__(self):
        self.ducks = []

    def add_duck(self, duck):
        self.ducks.append(duck)

    def create_random_duck(self):
        selection = random.randint(1,4)
        if selection == 1:
            return MallardDuck()
        elif selection == 2:
            return RedheadDuck()
        elif selection == 3:
            return DecoyDuck()
        else:
            return RubberDuck()

    def simulate(self):
        print "-" * 70
        for duck in self.ducks:
            duck.display()
            duck.performFly()
            duck.performQuack()
            duck.swim()
            print "-" * 70

if __name__ == '__main__':
    sim = DuckSimulator()
    num_ducks = random.randint(10, 20)
    for index in range(num_ducks):
        sim.add_duck(sim.create_random_duck())
    sim.simulate()
