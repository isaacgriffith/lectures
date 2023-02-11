#!/bin/sh

cd handouts
rm ../../production/handouts/*.pdf
for i in *.md; do
  [ -f "$i" ] || break
  pandoc $i --template=../../../common/templates/handout_template.latex --top-level-division=section --pdf-engine=xelatex --listings -o ../../production/handouts/${i%%.*}.pdf
done
