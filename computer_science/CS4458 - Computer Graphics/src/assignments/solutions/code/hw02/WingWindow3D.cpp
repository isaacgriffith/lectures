//
// Created by grifisaa on 9/15/19.
//

#include "WingWindow3D.h"
#include "Colors.h"
#include <GL/glew.h>
#include <GL/freeglut.h>

void WingWindow3D::draw() {

    setList(glGenLists(1));

    glNewList(list, GL_COMPILE);

    glColor3fv(WINDOW_FRAME);
    glPushMatrix();
    glScaled(4, .5, .3);
    glTranslated(x, y, z);
    glutSolidCube(1);
    glPopMatrix();

    glPushMatrix();
    glScaled(.2, 3.3, .3);
    glTranslated(x, y, z);
    glutSolidCube(1);
    glPopMatrix();

    glPushMatrix();
    glScaled(.2, 3.3, .3);
    glTranslated(x, y, z);
    glutSolidCube(1);
    glPopMatrix();

    glPushMatrix();
    glScaled(.2, 3.3, .3);
    glTranslated(x, y, z);
    glutSolidCube(1);
    glPopMatrix();

    glPushMatrix();
    glScaled(1.7, .2, .3);
    glTranslated(x, y, z);
    glutSolidCube(1);
    glPopMatrix();

    glPushMatrix();
    glScaled(1.7, .2, .3);
    glTranslated(x, y, z);
    glutSolidCube(1);
    glPopMatrix();

    glPushMatrix();
    glScaled(4, .2, .3);
    glTranslated(x, y, z);
    glutSolidCube(1);
    glPopMatrix();

    // Glass Panes
    for (int i = 0; i < 4; i++) {
        glPushMatrix();
        glScaled(1.8, 1.8, 0.2);
        glTranslated(x, y, z);
        glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, GLASS);
        glMaterialfv(GL_FRONT, GL_SPECULAR, WHITE_4);
        glMaterialfv(GL_FRONT, GL_SHININESS, GLASS_SHINY);
        glutSolidCube(1);
        glPopMatrix();
    }

    glEndList();
}
