//
// Created by grifisaa on 9/15/19.
//

#include "House3D.h"
#include "Colors.h"
#include <GL/glew.h>
#include <GL/freeglut.h>

House3D::House3D(GLfloat *mainColor, GLfloat *offColor, GLfloat *doorColor, GLfloat *offDoorColor) {
    east = new HouseWing3D(offColor, doorColor);
    eastRoof = new WingRoof3D(offColor);
    north = new HouseWing3D(mainColor, doorColor);
    northRoof = new WingRoof3D(mainColor);
    south = new HouseWing3D(mainColor);
    southRoof = new WingRoof3D(mainColor, offDoorColor);
    west = new HouseWing3D(mainColor, offDoorColor);
    westRoof = new WingRoof3D(mainColor);
    floor = new Floor3DTile[2][2];
    bricks = new Brick3D[5][5];
}

void House3D::draw() {
    setList(glGenLists(1));

    east->draw();
    west->draw();
    north->draw();
    south->draw();
    eastRoof->draw();
    westRoof->draw();
    northRoof->draw();
    southRoof->draw();

    for (int i = 0; i < bricks.length; i++)
    {
        for (int j = 0; j < bricks[i].length; j++)
        {
            bricks[i][j] = new Brick3D(2);
            bricks[i][j]->draw();
        }
    }

    glNewList(list, GL_COMPILE_AND_EXECUTE);

    glPushMatrix();
    glRotated(90, 0, 1, 0);
    glTranslated(7, 0, 0);
    glCallList(north.getList());
    glTranslated(7, 0, 0);
    glPopMatrix();
    glLoadIdentity();

    glPushMatrix();
    glRotated(90, 0, 1, 0);
    glTranslated(7, 11, 0);
    glCallList(northRoof->getList());
    glTranslated(0, 0, 0);
    glPopMatrix();
    glLoadIdentity();

    glPushMatrix();
    glRotated(180, 0, 1, 0);
    glTranslated(7, 0, 0);
    glCallList(west->getList());
    glTranslated(7, 0, 0);
    glPopMatrix();
    glLoadIdentity();

    glPushMatrix();
    glRotated(180, 0, 1, 0);
    glTranslated(7, 11, 0);
    glCallList(westRoof->getList());
    glTranslated(0, 0, 0);
    glPopMatrix();
    glLoadIdentity();

    glPushMatrix();
    glRotated(270, 0, 1, 0);
    glTranslated(7, 0, 0);
    glCallList(south->getList());
    glTranslated(7, 0, 0);
    glPopMatrix();
    glLoadIdentity();

    glPushMatrix();
    glRotated(270, 0, 1, 0);
    glTranslated(7, 11, 0);
    glCallList(southRoof->getList());
    glTranslated(0, 0, 0);
    glPopMatrix();
    glLoadIdentity();

    glPushMatrix();
    glTranslated(7, 0, 0);
    glCallList(east->getList());
    glTranslated(6, 0, 0);
    glPopMatrix();
    glLoadIdentity();

    glPushMatrix();
    glTranslated(7, 11, 0);
    glCallList(eastRoof->getList());
    glTranslated(0, 0, 0);
    glPopMatrix();
    glLoadIdentity();

    glPushMatrix();
    glTranslated(0, 15, 0);
    glScaled(14, 10, 14);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
    glLoadIdentity();

    int count = 0;
    for (int k = 0; k < 5; k++)
    {
        for (int i = 0; i < bricks.length; i++)
        {
            for (int j = 0; j < bricks[i].length; j++)
            {
                glPushMatrix();
                glTranslated((27 + 0.2 * j) + k, 0, -1 + 0.4 * i);
                glCallList(bricks[i][j]->getList());
                glPopMatrix();
                glLoadIdentity();

                if (count == 5)
                    count = 0;
                else
                    count++;
            }
        }
    }

    glEndList();
}
