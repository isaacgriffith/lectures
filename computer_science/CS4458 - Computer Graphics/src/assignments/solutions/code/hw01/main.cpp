#include <cstdlib>
#include <cmath>
#include <iostream>

#include <GL/glew.h>
#include <GL/freeglut.h>

float newAngle = 60.0;
bool multi = false;
bool angleChanged = false;
bool stateChanged = false;
bool perspectiveChanged = false;

float newLocation[] = {0, 0, 5};
float newCenter[] = {0, 0, 1};
float newUp[] = {0, 1, 0};

void firstColor(void) {
    if (multi) {
        double red = rand() / double(RAND_MAX);
        double green = rand() / double(RAND_MAX);
        double blue = rand() / double(RAND_MAX);
        glColor3d(red, green, blue);
    } else {
        glColor3d(1.0, 0.0, 0.0);
    }
}

void secondColor(void) {
    if (multi) {
        double red = rand() / double(RAND_MAX);
        double green = rand() / double(RAND_MAX);
        double blue = rand() / double(RAND_MAX);
        glColor3d(red, green, blue);
    } else {
        glColor3d(0.0, 0.0, 1.0);
    }
}

void updateDisplay() {
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(newAngle, 1.0, 1.0, 100.0);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    gluLookAt(newLocation[0], newLocation[1], newLocation[2], newCenter[0], newCenter[1], newCenter[2], newUp[0], newUp[1], newUp[2]);

    perspectiveChanged = false;
    angleChanged = false;
    stateChanged = true;
}

void drawScene(void) {
    if (angleChanged || perspectiveChanged) {
        updateDisplay();
    }

    if (stateChanged) {
        glClear(GL_COLOR_BUFFER_BIT);
        glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);

        glBegin(GL_QUADS);
        glColor3f(1, 0, 0);

        int xVals[] = {0, 0, -5, -5};
        int yVals[] = {0, 5, 5, 0};

        for (int baseY = 0; baseY < 30; baseY += 5) {
            for (int baseX = 0; baseX > -30; baseX -= 5) {
                firstColor();
                for (int i = 0; i < 4; i++) {
                    glVertex3i(baseX + xVals[i], baseY + yVals[i], 2);
                }
            }
        }

        for (int baseY = -20; baseY < 0; baseY += 5) {
            for (int baseX = 20; baseX > 0; baseX -= 5) {
                secondColor();
                for (int i = 0; i < 4; i++) {
                    glVertex3i(baseX + xVals[i], baseY + yVals[i], 0);
                }
            }
        }
        glEnd();

        stateChanged = false;

        glutSwapBuffers();
    }
}

void setup(void) {
    glClearColor(0.0, 0.0, 0.0, 0.0);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(60.0, 1.0, 1.0, 100.0);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    gluLookAt(0, 0, 5, 0, 0, 1, 0, 1, 0);
}

void resize(int w, int h) {
    glViewport(0, 0, w, h);
}

void changeAngle(float angle) {
    newAngle = angle;

    angleChanged = true;
}

void changeSettings(float eyex, float eyey, float eyez, float centx, float centy, float centz, float upx, float upy, float upz) {
    newCenter[0] = centx;
    newCenter[1] = centy;
    newCenter[2] = centz;
    newLocation[0] = eyex;
    newLocation[1] = eyey;
    newLocation[2] = eyez;
    newUp[0] = upx;
    newUp[1] = upy;
    newUp[2] = upz;

    perspectiveChanged = true;
}

void keyInput(unsigned char key, int x, int y) {

    switch (key) {
        case 27:
        case 'q':
            exit(0);
        case '1':
            changeSettings(-5.0f, 5.0f, 50, -5.0f, 5.0f, 1.0f, 0, 1, 0);
            changeAngle(60.0);
            multi = false;
            glutPostRedisplay();
            break;
        case '2':
            changeSettings(-52, 0, -52, 0, 0, 0, 1, 1, -1);
            changeAngle(60.0);
            multi = false;
            glutPostRedisplay();
            break;
        case '3':
            changeSettings(-5.0f, 5.0f, 50, -5.0f, 5.0f, 1.0f, 0, 1, 0);
            changeAngle(60.0);
            multi = true;
            glutPostRedisplay();
            break;
        case '4':
            changeSettings(-3.0f, 3.0f, 22.5f, -3.0f, 3.0f, 0.0f, 0, 1, 0);
            changeAngle(60.0);
            multi = true;
            glutPostRedisplay();
            break;
        default:
            break;
    }
}

int main(int argc, char **argv) {
    glutInit(&argc, argv);

    glutInitContextVersion(3, 0);
    glutInitContextProfile(GLUT_COMPATIBILITY_PROFILE);

    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA);
    glutInitWindowSize(500, 500);
    glutInitWindowPosition(3060, 100);
    glutCreateWindow("CS 4458: Homework 1");
    glutDisplayFunc(drawScene);
    glutReshapeFunc(resize);
    glutKeyboardFunc(keyInput);

    glewExperimental = GL_TRUE;
    glewInit();

    setup();

    glutMainLoop();
}