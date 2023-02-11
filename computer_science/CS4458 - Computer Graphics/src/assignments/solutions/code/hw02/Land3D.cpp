//
// Created by grifisaa on 9/15/19.
//

#include "Land3D.h"
#include "Colors.h"
#include <GL/glew.h>
#include <GL/freeglut.h>

void Land3D::draw() {
    setList(glGenLists(1));

    glNewList(list, GL_COMPILE);

    glPushMatrix();
    glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, DIRT_BROWN);
    glMaterialfv(GL_FRONT, GL_SPECULAR, WHITE_4);
    glMaterialfv(GL_FRONT, GL_SHININESS, GLASS_SHINY);
    glScaled(80.0, 1, 80.0);
    glTranslated(0, -1, 0);
    glutSolidCube(1);
    glPopMatrix();

    glPushMatrix();
    glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, GRASS_GREEN);
    glMaterialfv(GL_FRONT, GL_SPECULAR, WHITE_4);
    glMaterialfv(GL_FRONT, GL_SHININESS, GLASS_SHINY);

    glBegin(GL_POLYGON);
    glVertex3d(-40.0, 0, 40.0);
    glVertex3d(40.0, 0, 40.0);
    glVertex3d(40.0, 0, -40.0);
    glVertex3d(-40.0, 0, -40.0);
    glEnd();

    glTranslated(40, 0, 40);
    glPopMatrix();

    glEndList();
}
