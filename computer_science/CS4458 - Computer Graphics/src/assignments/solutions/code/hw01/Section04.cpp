//
// Created by grifisaa on 9/15/19.
//

#include "Section04.h"
#include <GL/glew.h>
#include <GL/freeglut.h>

void Section04::draw() {

    //gluLookAt();

    for (int x = 0; x < 6; x++) {
        for (int y = 0; y < 6; y++) {
            glBegin(GL_POLYGON);
            glColor3d(1.0, 0.0, 0.0);
            glVertex3d(x * 5.0, y * 5.0, 2.0);
            glVertex3d(x * 5.0, (y + 1) * 5.0, 2.0);
            glVertex3d((x + 1) * -5.0, (y + 1) * 5.0, 2.0);
            glVertex3d((x + 1) * -5.0, y * 5.0, 2.0);
            glEnd();
        }
    }

    for (int x = 0; x < 4; x++) {
        for (int y = 0; y < 4; y++) {
            glBegin(GL_POLYGON);
            glColor3d(0.0, 0.0, 1.0);
            glVertex3d(x * 5.0, y * 5.0, 0.0);
            glVertex3d(x * 5.0, (y + 1) * -5.0, 0.0);
            glVertex3d((x + 1) * 5.0, (y + 1) * -5.0, 0.0);
            glVertex3d((x + 1) * 5.0, y * 5.0, 0.0);
            glEnd();
        }
    }
}
