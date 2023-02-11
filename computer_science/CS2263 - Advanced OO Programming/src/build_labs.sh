#!/bin/sh

cd labs
rm ../../production/labs/*.pdf
for i in *.md; do
  [ -f "$i" ] || break
  pandoc $i --template=../../../common/templates/assignment_template.latex --top-level-division=section --pdf-engine=xelatex --listings -o ../../production/labs/${i%%.*}.pdf
done
