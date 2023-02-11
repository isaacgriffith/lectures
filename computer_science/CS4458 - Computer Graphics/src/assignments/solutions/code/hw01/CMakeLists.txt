cmake_minimum_required(VERSION 3.12)
project(hw01)

set(CMAKE_CXX_STANDARD 14)

add_executable(hw01 main.cpp Section.h Section01.cpp Section01.h Section02.cpp Section02.h Section03.cpp Section03.h Section04.cpp Section04.h)
find_package(OpenGL REQUIRED)
find_package(GLUT REQUIRED)
find_package(GLEW REQUIRED)
include_directories( ${OPENGL_INCLUDE_DIRS}  ${GLUT_INCLUDE_DIRS} ${GLEW_INCLUDE_DIRS})

target_link_libraries(hw01 ${OPENGL_LIBRARIES} ${GLUT_LIBRARY} ${GLEW_LIBRARIES})