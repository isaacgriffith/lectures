//
// Created by grifisaa on 9/15/19.
//

#include "Section01.h"
#include <GL/glew.h>
#include <GL/freeglut.h>
#include <cstdlib>
#include <iostream>

void Section01::draw() {

//    glPushMatrix();
//    glPopMatrix();

    glColor3d(1.0, 0.0, 0.0);
    glBegin(GL_POLYGON);
    glVertex3d(0.0, 0.0, 2.0);
    glVertex3d(0.0, 30.0, 2.0);
    glVertex3d(-30.0, 30.0, 2.0);
    glVertex3d(-30.0, 0.0, 2.0);
    glEnd();

    glColor3d(0.0, 0.0, 1.0);
    glBegin(GL_POLYGON);
    glVertex3d(0.0, 0.0, 0.0);
    glVertex3d(0.0, -20.0, 0.0);
    glVertex3d(20.0, -20.0, 0.0);
    glVertex3d(20.0, 0.0, 0.0);
    glEnd();

    gluLookAt(0.0, 0.0, -23.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
    std::cout << "Drawn from Sect 01\n";
}
