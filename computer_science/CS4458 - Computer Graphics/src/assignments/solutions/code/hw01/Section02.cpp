//
// Created by grifisaa on 9/15/19.
//

#include "Section02.h"
#include <GL/glew.h>
#include <GL/freeglut.h>

void Section02::draw() {

    //gluLookAt();

    glBegin(GL_POLYGON);
    glColor3f(1.0, 0.0, 0.0);
    glVertex3f(0.0, 0.0, 2.0);
    glVertex3f(0.0, 30.0, 3.0);
    glVertex3f(-30.0, 30.0, 3.0);
    glVertex3f(-30.0, 0.0, 2.0);
    glEnd();

    glBegin(GL_POLYGON);
    glColor3f(0.0, 0.0, 1.0);
    glVertex3f(0.0, 0.0, 0.0);
    glVertex3f(0.0, -20.0, 0.0);
    glVertex3f(20.0, -20.0, 0.0);
    glVertex3f(20.0, 0.0, 0.0);
    glEnd();
}
