#!/bin/sh

cd lectures
rm ../../production/lectures/*.pdf
for i in *.md; do
  [ -f "$i" ] || break
  pandoc $i --template=../templates/lecture_template.latex -t beamer --slide-level=1 --pdf-engine=xelatex -f markdown+fenced_code_attributes -f markdown+multiline_tables -o ../../production/lectures/${i%%.*}.pdf
done
