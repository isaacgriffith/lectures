#!/bin/sh

cd lectures
rm ../../production/lectures/*.pdf
for i in *.md; do
  [ -f "$i" ] || break
  name="$(basename -- "$i" .md)"
  pandoc $i --template=../../../common/templates/lecture_template.latex -t beamer --slide-level=1 --pdf-engine=xelatex -f markdown+fenced_code_attributes -f markdown+multiline_tables -o ../../production/lectures/$name.pdf
done
