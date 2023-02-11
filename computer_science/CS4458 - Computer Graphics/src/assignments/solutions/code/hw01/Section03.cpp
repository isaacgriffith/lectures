//
// Created by grifisaa on 9/15/19.
//

#include "Section03.h"
#include <GL/glew.h>
#include <GL/freeglut.h>

void Section03::draw() {

    //gluLookAt();

    for (int x = 0; x < 6; x++) {
        for (int y = 0; y < 6; y++) {
            double red = rand() / double(RAND_MAX);
            double green = rand() / double(RAND_MAX);
            double blue = rand() / double(RAND_MAX);
            glColor3d(red, green, blue);
            glBegin(GL_POLYGON);
            glVertex3d(x * -5.0, y * 5.0, 2.0);
            glVertex3d(x * -5.0, (y + 1) * 5.0, 2.0);
            glVertex3d((x + 1) * -5.0, (y + 1) * 5.0, 2.0);
            glVertex3d((x + 1) * -5.0, y * 5.0, 2.0);
            glEnd();
        }
    }

    for (int x = 0; x < 4; x++) {
        for (int y = 0; y < 4; y++) {
            double red = rand() / double(RAND_MAX);
            double green = rand() / double(RAND_MAX);
            double blue = rand() / double(RAND_MAX);
            glColor3d(red, green, blue);
            glBegin(GL_POLYGON);
            glVertex3d(x * 5.0, y * -5.0, 0.0);
            glVertex3d(x * 5.0, (y + 1) * -5.0, 0.0);
            glVertex3d((x + 1) * 5.0, (y + 1) * -5.0, 0.0);
            glVertex3d((x + 1) * 5.0, y * -5.0, 0.0);
            glEnd();
        }
    }
}
