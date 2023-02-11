//
// Created by grifisaa on 9/15/19.
//

#include "Window3D.h"

void Window3D::draw() {
    setList(glGenLists(1));
x
    glNewList(list, GL_COMPILE);

    glPushMatrix();
    glRectd(-1.5, -2.5, 1.5, 2.5);
    glPopMatrix();

    glEndList();
}
