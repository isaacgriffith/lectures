//
// Created by grifisaa on 9/15/19.
//

#ifndef HW02_HOUSE3D_H
#define HW02_HOUSE3D_H

#include "Object3D.h"
#include "HouseWing3D.h"
#include "Floor3DTile.h"
#include "WingRoof3D.h"
#include "Brick3D.h"

class House3D: Object3D {

private:
    HouseWing3D east;
    HouseWing3D west;
    HouseWing3D north;
    HouseWing3D south;
    Floor3DTile floor[][];
    WingRoof3D eastRoof;
    WingRoof3D northRoof;
    WingRoof3D southRoof;
    WingRoof3D westRoof;
    Brick3D bricks[][];

public:
    House3D(GLfloat* mainColor, GLfloat* offColor, GLfloat* doorColor, GLfloat* offDoorColor);

private:
    void draw() override;
};


#endif //HW02_HOUSE3D_H
