#!/bin/sh

cd assignments
rm ../../production/assignments/*.pdf
rm ../../production/assignments/solutions/*.pdf
for i in *.md; do
  [ -f "$i" ] || break
  pandoc $i --template=../../../common/templates/assignment_template.latex --top-level-division=section --pdf-engine=xelatex --listings -o ../../production/assignments/${i%%.*}.pdf
done

cd solutions
for i in *.md; do
  [ -f "$i" ] || break
  pandoc $i --template=../../../../common/templates/assignment_sol_template.latex --top-level-division=section --pdf-engine=xelatex --listings -o ../../../production/assignments/solutions/${i%%.*}.pdf
done
