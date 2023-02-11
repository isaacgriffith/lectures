#!/bin/sh

cd exams
rm ../../production/exams/given/*.pdf
rm ../../production/exams/practice/*.pdf
rm ../../production/exams/keys/*.pdf
# cd given
# for i in *.md; do
#   [ -f "$i" ] || break
#   pandoc $i --template=../../../../common/templates/exam_template.latex --top-level-division=section --pdf-engine=xelatex --listings -o ../../../production/exams/given/${i%%.*}.pdf
#   pandoc $i --template=../../../../common/templates/exam_key_template.latex --top-level-division=section --pdf-engine=xelatex --listings -o ../../../production/exams/keys/${i%%.*}.pdf
# done
# cd ..

cd practice
for i in *.md; do
  [ -f "$i" ] || break
  echo $i
  pandoc $i --template=../../../../common/templates/exam_template.latex --top-level-division=section --pdf-engine=xelatex --listings -o ../../../production/exams/practice/${i%%.*}.pdf
done
cd ..
cd keys
for i in *.md; do
  [ -f "$i" ] || break
  pandoc $i --template=../../../../common/templates/exam_template.latex --top-level-division=section --pdf-engine=xelatex --listings -o ../../../production/exams/keys/${i%%.*}.pdf
done
