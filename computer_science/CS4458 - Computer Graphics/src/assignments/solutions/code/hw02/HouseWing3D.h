//
// Created by grifisaa on 9/15/19.
//

#ifndef HW02_HOUSEWING3D_H
#define HW02_HOUSEWING3D_H

#include "Object3D.h"
#include "WingWindow3D.h"
#include "Floor3DTile.h"
#include "Door3D.h"
#include "WingRoof3D.h"

class HouseWing3D: Object3D {
private:
    Floor3DTile[][] tiles;
    Door3D door;
    WingWindow3D frontWindow;
    WingRoof3D roof;
    WingWindow3D* rightWindows;
    WingWindow3D* leftWindows;
    GLfloat* wallColor;

public:
    HouseWing3D(GLfloat* wallColor, GLfloat* doorColor);

    void draw() override;
};

#endif //HW02_HOUSEWING3D_H
