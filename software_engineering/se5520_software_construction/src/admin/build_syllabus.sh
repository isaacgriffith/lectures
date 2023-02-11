#!/bin/sh

set -e

pp syllabus.md > syllabus.gen.md

pandoc syllabus.gen.md --template=../../../common/templates/syllabus_template.latex --top-level-division=section --pdf-engine=xelatex -o ../../production/layout/admin/syllabus.pdf

rm syllabus.gen.md
