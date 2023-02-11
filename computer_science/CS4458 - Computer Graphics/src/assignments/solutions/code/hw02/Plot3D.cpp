//
// Created by grifisaa on 9/15/19.
//

#include "Plot3D.h"
#include "House3D.h"
#include "Garage3D.h"
#include "Colors.h"
#include <GL/glew.h>
#include <GL/freeglut.h>

void Plot3D::draw() {
    setList(glGenLists(1));

    House3D house = new House3D(BRICK_1, BRICK_2, DOOR_BLUE, DOOR_YELLOW);
    //Land3D land = new Land3D();
    Garage3D garage = new Garage3D();

    house->draw();
    //land->draw();
    garage->draw();

    glNewList(list, GL_COMPILE);

//        glPushMatrix();
//        glCallList(land.getList());
//        glTranslated(40, 0, 40);
//        glPopMatrix();

    glPushMatrix();
    glTranslated(30, 0, 20);
    glCallList(house->getList());
    glPopMatrix();
//
//        glPushMatrix();
//        glTranslated(-60, 0, -50);
//        glCallList(garage.getList());
//        glPopMatrix();

    glEndList();
}
