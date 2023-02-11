#!/bin/sh

cd project
rm ../../production/project/*.pdf
for i in pi*.md; do
  [ -f "$i" ] || break
  pandoc $i --template=../../../common/templates/assignment_template.latex --top-level-division=section --pdf-engine=xelatex --listings -o ../../production/project/${i%%.*}.pdf
done
