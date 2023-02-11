//
// Created by grifisaa on 9/15/19.
//

#include "Roof3D.h"

void Roof3D::draw() {
    setList(glGenLists(1));

    double[] xVals_1 = { 3, 1, -1, -3 };
    double[] yVals_1 = { -6, -2.5, -2.5, -6 };
    double[] zVals = { 0, 3, -0.2, 2.8 };

    double[] xVals_2 = { 3, -1, -3, -9 };
    double[] yVals_2 = { -6, -2.5, -1, -3 };

    double[] xVals_3 = { -9, -3, -3, -9 };
    double[] yVals_3 = { -3, -1, 1, 3 };

    double[] xVals_4 = { -9, -3, -1, -3 };
    double[] yVals_4 = { 3, 1, 2.5, 6 };

    double[] xVals_5 = { -3, -1, 1, 3 };
    double[] yVals_5 = { 6, 2.5, 2.5, 6 };

    double[] xVals_6 = { 3, 1, 3, 9 };
    double[] yVals_6 = { 6, 2.5, 1, 3 };

    double[] xVals_7 = { 9, 3, 3, 9 };
    double[] yVals_7 = { 3, 1, -1, -3 };

    double[] xVals_8 = { 9, 3, 1, 3 };
    double[] yVals_8 = { -3, -1, -2.5, -6 };

    double[] xVals_9 = { 1, -1, -3, -3, -1, 1, 3, 3 };
    double[] yVals_9 = { -2.5, -2.5, -1, 1, 2.5, 2.5, 1, -1 };

    double[][][] mrc = { { xVals_1, xVals_2, xVals_3, xVals_4, xVals_5, xVals_6, xVals_7, xVals_8 },
                         { yVals_1, yVals_2, yVals_3, yVals_4, yVals_5, yVals_6, yVals_7, yVals_8 } };

    glNewList(list, GL_COMPILE);

    for (int i = 0; i < mrc[0].length; i++)
    {
        glPushMatrix();
        glBegin(GL_POLYGON);
        glColor3d(0.25, 0.25, 0.25);
        glVertex3d(mrc[0][i][0], mrc[1][i][0], zVals[0]);
        glVertex3d(mrc[0][i][1], mrc[1][i][1], zVals[1]);
        glVertex3d(mrc[0][i][2], mrc[1][i][2], zVals[1]);
        glVertex3d(mrc[0][i][3], mrc[1][i][3], zVals[0]);

        glColor3d(0.33, 0.33, 0.33);
        glVertex3d(mrc[0][i][0], mrc[1][i][0], zVals[2]);
        glVertex3d(mrc[0][i][0], mrc[1][i][0], zVals[0]);
        glVertex3d(mrc[0][i][3], mrc[1][i][0], zVals[0]);
        glVertex3d(mrc[0][i][3], mrc[1][i][0], zVals[2]);

        glVertex3d(mrc[0][i][1], mrc[1][i][2], zVals[3]);
        glVertex3d(mrc[0][i][1], mrc[1][i][2], zVals[1]);
        glVertex3d(mrc[0][i][0], mrc[1][i][3], zVals[0]);
        glVertex3d(mrc[0][i][0], mrc[1][i][3], zVals[2]);

        glVertex3d(mrc[0][i][2], mrc[1][i][2], zVals[3]);
        glVertex3d(mrc[0][i][2], mrc[1][i][2], zVals[1]);
        glVertex3d(mrc[0][i][3], mrc[1][i][3], zVals[0]);
        glVertex3d(mrc[0][i][3], mrc[1][i][3], zVals[2]);

        glVertex3d(mrc[0][i][1], mrc[1][i][1], zVals[3]);
        glVertex3d(mrc[0][i][1], mrc[1][i][1], zVals[1]);
        glVertex3d(mrc[0][i][2], mrc[1][i][1], zVals[1]);
        glVertex3d(mrc[0][i][2], mrc[1][i][1], zVals[3]);

        glVertex3d(mrc[0][i][0], mrc[1][i][0], zVals[2]);
        glVertex3d(mrc[0][i][1], mrc[1][i][1], zVals[3]);
        glVertex3d(mrc[0][i][2], mrc[1][i][2], zVals[3]);
        glVertex3d(mrc[0][i][3], mrc[1][i][3], zVals[2]);
        glEnd();
        glPopMatrix();
    }
    glPushMatrix();
    glBegin(GL_POLYGON);
    glColor3d(0.25, 0.25, 0.25);
    for (int i = 0; i < xVals_9.length; i++)
    {
        glVertex3d(xVals_9[i], yVals_9[i], 3);
    }

    glColor3d(0.33, 0.33, 0.33);
    for (int i = 0; i < xVals_9.length; i++)
    {
        glVertex3d(xVals_9[i], yVals_9[i], 2.8);
    }
    glEnd();
    glEndList();
}
