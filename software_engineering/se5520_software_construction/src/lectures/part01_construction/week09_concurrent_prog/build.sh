#!/bin/bash

set -e

pp $1.md > $1.gen.md
pandoc $1.gen.md --verbose --template=../../../../../common/templates/lecture_template.latex -t beamer --slide-level 1 --pdf-engine=xelatex -f markdown+fenced_code_attributes -f markdown+multiline_tables -o ../../../../production/layout/part01_construction/week09_concurrent_prog/$1.pdf
rm $1.gen.md
