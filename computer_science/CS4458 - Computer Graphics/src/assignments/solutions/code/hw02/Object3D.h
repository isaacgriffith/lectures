//
// Created by grifisaa on 9/15/19.
//

#ifndef HW02_OBJECT3D_H
#define HW02_OBJECT3D_H


#include <GL/glew.h>

class Object3D {

protected:
    GLuint list;

public:
    int getList() {
        return this->list;
    }

    void setList(GLuint list) {
        this->list = list;
    }

    virtual void draw() = 0;
};

#endif //HW02_OBJECT3D_H
