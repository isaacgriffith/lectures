#!/bin/sh

rm ../production/syllabus.pdf
pandoc syllabus.md --template=templates/syllabus_template.latex --top-level-division=section --pdf-engine=xelatex -o ../production/syllabus.pdf
