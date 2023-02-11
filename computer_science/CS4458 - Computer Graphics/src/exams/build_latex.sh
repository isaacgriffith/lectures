#!/bin/bash

set -e

pp $1.md > $1.gen.md

pandoc $1.gen.md \
  --template=../../templates/exam_template.latex \
  --top-level-division=section \
  -f markdown+fenced_code_attributes+multiline_tables+tex_math_single_backslash+fenced_divs \
  -o $1.tex \

pandoc $1.gen.md \
  --template=../../templates/exam_template.latex \
  --top-level-division=section \
  -f markdown+fenced_code_attributes+multiline_tables+tex_math_single_backslash+fenced_divs \
  -M answers:true \
  -o $1_solutions.tex \
