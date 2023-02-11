//
// Created by grifisaa on 9/15/19.
//

#include <GL/freeglut.h>
#include "HouseWing3D.h"

HouseWing3D::HouseWing3D(GLfloat *wallColor, GLfloat *doorColor) {
    tiles = new Floor3DTile[3][5];
    door = new Door3D(doorColor);
    rightWindows = new WingWindow3D[3];
    leftWindows = new WingWindow3D[3];
    frontWindow = new WingWindow3D();

    for (int i = 0; i < tiles.length; i++)
    {
        for (int j = 0; j < tiles[i].length; j++)
        {
//                if ((i + j) % 2 == 0)
//                {
//                    tiles[i][j] = new Floor3DTile(Colors.getColor(Colors.BLACK), Colors.getColor(Colors.WHITE));
//                }
//                else {
            tiles[i][j] = new Floor3DTile(4, Colors.getColor(Colors.WHITE), Colors.getColor(Colors.BLACK));
//                }
        }
    }

    // for (int i = 0; i < leftWindows.length; i++)
    // {
    // leftWindows[i] = new WingWindow3D();
    // rightWindows[i] = new WingWindow3D();
    // }

    this.wallColor = wallColor;
    roof = new WingRoof3D(wallColor);
}

void HouseWing3D::draw() {
    setList(glGenLists(1));

    roof.draw();
    door.draw();

    for (int i = 0; i < tiles.length; i++) {
        for (int j = 0; j < tiles[i].length; j++) {
            tiles[i][j].draw(drawable, glut, glu);
        }
    }

    glNewList(list, GL_COMPILE);

    // right side
    glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, wallColor);
    glMaterialfv(GL_FRONT, GL_SPECULAR, Colors.getColor(Colors.WHITE_4));
    glMaterialfv(GL_FRONT, GL_SHININESS, Colors.getColor(Colors.GLASS_SHINY));
    glPushMatrix();
    glTranslated(10, 2.5, 6.5);
    glScaled(20, 5, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(10, 10, 6.5);
    glScaled(20, 2, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(1, 7, 6.5);
    glScaled(2, 4, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(7, 7, 6.5);
    glScaled(2, 4, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(13, 7, 6.5);
    glScaled(2, 4, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(19, 7, 6.5);
    glScaled(2, 4, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();

    // // add windows
    // for (int i = 0; i < rightWindows.length; i++)
    // {
    // glPushMatrix();
    // glTranslated(x, y, z);
    // glRotated(180, 0, 1, 0);
    // glCallList(rightWindows[i].getList());
    // glTranslated(0, 0, 0);
    // glPopMatrix();
    // }

    // Left Side
    glPushMatrix();
    glTranslated(10, 10, -6.5);
    glScaled(20, 2, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(1, 7, -6.5);
    glScaled(2, 4, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(7, 7, -6.5);
    glScaled(2, 4, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(13, 7, -6.5);
    glScaled(2, 4, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(19, 7, -6.5);
    glScaled(2, 4, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(10, 2.5, -6.5);
    glScaled(20, 5, 1);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    // // add windows
    // for (int i = 0; i < leftWindows.length; i++)
    // {
    // glPushMatrix();
    // glTranslated(x, y, z);
    // glCallList(leftWindows[i].getList());
    // glTranslated(0, 0, 0);
    // glPopMatrix();
    // }

    // Front
    glPushMatrix();
    glTranslated(19.5, 10.5, 0);
    glScaled(1, 1, 12);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(19.5, 8, 4);
    glScaled(1, 4, 4);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(19.5, 8, -4);
    glScaled(1, 4, 4);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(19.5, 5.5, 0);
    glScaled(1, 1, 12);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(19.5, 2.5, 4);
    glScaled(1, 5, 4.5);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();
    glPushMatrix();
    glTranslated(19.5, 2.5, -4);
    glScaled(1, 5, 4.5);
    glutSolidCube(1);
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();

    // add window
    // glPushMatrix();
    // glTranslated(x, y, z);
    // glRotated(90, 0, 1, 0);
    // glCallList(frontWindow.getList());
    // glTranslated(0, 0, 0);
    // glPopMatrix();

    // add door
    glPushMatrix();
    glTranslated(18.15, .5, 0);
    glCallList(door.getList());
    glTranslated(0, 0, 0);
    glPopMatrix();
//        glLoadIdentity();

    // Floor
    for (int i = 0; i < tiles.length; i++)
    {
        for (int j = 0; j < tiles[i].length; j++)
        {
            glPushMatrix();
            glTranslated(4 * j, 0, 4 * i - 6);
            glCallList(tiles[i][j].getList());
            glTranslated(0, 0, 0);
            glPopMatrix();

        }
    }

//        glPushMatrix();
//        glTranslated(0, 11, 0);
//        glCallList(roof.getList());
//        glTranslated(0, 0, 0);
    glPopMatrix();

    glEndList();
}
